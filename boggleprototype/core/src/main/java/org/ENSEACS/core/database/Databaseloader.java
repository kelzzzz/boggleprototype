package org.ENSEACS.core.database;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.net.URL;

import java.sql.*;
// EdilsonAlberto
// Edilson Alberto - Databaseloader is a class that was created to help find first the file, in this case the dictionary
public class Databaseloader {
    // To load the file, we need a method that uses the Connection API class
    public static Connection loadToMyMemoryDB() {
        String filePath = Gdx.files.internal("dictionary.db").file().getAbsolutePath();

        try {
            Connection connectionofDisk = DriverManager.getConnection("jdbc:sqlite:" + filePath);
            Connection connectionwMemory  = DriverManager.getConnection("jdbc:sqlite::memory:");
            // We run some queries of our database
            Statement something = connectionwMemory.createStatement();
            something.execute("ATTACH DATABASE '" + filePath + "' AS src;");
            something.execute("CREATE TABLE entries AS SELECT * FROM src.entries;");
            something.execute("DETACH DATABASE src;");
            connectionofDisk .close();
            return connectionwMemory;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to load in-memory DB", e);
        }
    }

}

