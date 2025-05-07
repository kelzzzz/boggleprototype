package org.ENSEACS.core;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
public class Databaseloader {

    public static Connection loadToMyMemoryDB() {
        String userDirectory = System.getProperty("user.dir");
        Path databasePath = Paths.get(userDirectory, "assets", "dictionary.db");
        if (!Files.exists(databasePath)) {
            databasePath = Paths.get(userDirectory, "..", "assets", "dictionary.db").normalize();
        }
        if (!Files.exists(databasePath)) {
            throw new RuntimeException("dictionary.db file not found in:\n  " + Paths.get(userDirectory, "assets", "dictionary.db") + "\n  " + Paths.get(userDirectory, "..", "assets", "dictionary.db"));
        }
        String filePath = databasePath.toAbsolutePath().toString();
        try {
            Connection diskConn = DriverManager.getConnection("jdbc:sqlite:" + filePath);
            Connection memConn  = DriverManager.getConnection("jdbc:sqlite::memory:");

            try (Statement st = memConn.createStatement()) {
                st.execute("ATTACH DATABASE '" + filePath + "' AS src;");
                st.execute("CREATE TABLE entries AS SELECT * FROM src.entries;");
                st.execute("DETACH DATABASE src;");
            }
            diskConn.close();
            return memConn;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to load in-memory DB", e);
        }
    }

}

