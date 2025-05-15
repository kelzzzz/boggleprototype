package org.ENSEACS.core.database;
import com.badlogic.gdx.Gdx;

import java.sql.*;
// EdilsonAlberto
// Edilson Alberto - Databaseloader is a class that was created to help find first the file, in this case the dictionary
public class DatabaseLoader {
    // To load the file, we need a method that uses the Connection API class
    public static Connection loadToMyMemoryDB() {
        String filePath = Gdx.files.internal("assets/dictionary.db").file().getAbsolutePath();
        System.out.println(filePath);

        try {
            Connection connectionofDisk = DriverManager.getConnection("jdbc:sqlite:" + filePath);
            Connection connectionwMemory  = DriverManager.getConnection("jdbc:sqlite::memory:");
            // We run some queries of our database
            Statement statement = connectionwMemory.createStatement();
            statement.execute("ATTACH DATABASE '" + filePath + "' AS src;");
            statement.execute("CREATE TABLE entries AS SELECT * FROM src.entries;");
            statement.execute("DETACH DATABASE src;");
            connectionofDisk.close();
            return connectionwMemory;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to load in-memory DB", e);
        }
    }

}

