package org.ENSEACS.core.database;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
// EdilsonAlberto
// Edilson Alberto - Databaseloader is a class that was created to help find first the file, in this case the dictionary
public class Databaseloader {
    // To load the file, we need a method that uses the Connection API class
    public static Connection loadToMyMemoryDB() {
        // We first try to locate the file in the diffent folders we have
        String userDirectory = System.getProperty("user.dir");
        Path databasePath = Paths.get(userDirectory, "assets", "dictionary.db");
        // If it isn't found on this folder, it will go one level above to try again
        if (!Files.exists(databasePath)) {
            databasePath = Paths.get(userDirectory, "..", "assets", "dictionary.db").normalize();
        }
        // In case it doesn't find, it will return not found
        if (!Files.exists(databasePath)) {
            throw new RuntimeException("We didn't manage to find dictionary db in\n  " + Paths.get(userDirectory, "assets", "dictionary.db") + "\n  " + Paths.get(userDirectory, "..", "assets", "dictionary.db"));
        }
        // In case we find it, we convert to String and Connect with our Memory program
        String filePath = databasePath.toAbsolutePath().toString();
        try {
            Connection connectionofDisk = DriverManager.getConnection("jdbc:sqlite:" + filePath);
            Connection connectionwMemory  = DriverManager.getConnection("jdbc:sqlite::memory:");
            // We run some queries of our database
            try (Statement something = connectionwMemory.createStatement()) {
                something.execute("ATTACH DATABASE '" + filePath + "' AS src;");
                something.execute("CREATE TABLE entries AS SELECT * FROM src.entries;");
                something.execute("DETACH DATABASE src;");
            }
            connectionofDisk .close();
            return connectionwMemory;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to load in-memory DB", e);
        }
    }

}

