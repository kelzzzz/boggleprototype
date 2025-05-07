package org.ENSEACS.core;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.*;
import java.sql.*;
public class Databaseloader {

    public static Connection loadToMyMemoryDB(){
        Connection memconnection = null;

        try {
            FileHandle databaseFile = Gdx.files.internal("dictionary.db");
            String filePath = databaseFile.file().getAbsolutePath();

            Connection fileConnection = DriverManager.getConnection("jdbc:sqlite:" + filePath);
            memconnection = DriverManager.getConnection("jdbc:sqlite::memory:");

            Statement something = memconnection.createStatement();
            something.executeUpdate("ATTACH DATABASE '" + filePath + "' AS databaseFile;");
            something.executeUpdate("CREATE TABLE words AS SELECT * FROM databaseFile.entries;");
            something.executeUpdate("DETACH DATABASE databaseFile;");

            fileConnection.close();
            System.out.println("✅ Dictionary loaded into memory.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memconnection;
    }

}

