package org.ENSEACS.core;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.ENSEACS.core.Databaseloader;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class WordCheckerTest {

    static Connection connection;

    @BeforeAll
    public static void setup() {

        connection = Databaseloader.loadToMyMemoryDB();
//        String path = "C:\\Users\\edils\\IdeaProjects\\boggleprototype\\boggleprototype\\assets\\dictionary.db";
//        try {
//            connection = DriverManager.getConnection("jdbc:sqlite:" + path);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    @Test
    public void testDatabaseConnectionIsValid() {
        try {
            assertTrue(connection.isValid(1), "Database connection is not valid.");
            System.out.println("Connection to database is a success");
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Exception while validating connection.");
        }
    }
    @Test
    public void isCarThere() {
        try {
            Statement somethingToFind = connection.createStatement();
            ResultSet result = somethingToFind.executeQuery("SELECT 1 FROM entries WHERE word = 'car' LIMIT 1;");

            boolean found = result.next();
            assertTrue(found, "'car' was not found in your DB.");
            result.close();
            somethingToFind.close();

        } catch (SQLException e) {
            e.printStackTrace();
            fail("It failed.");
        }
    }
    @Test
    public void testIfWordIsntThere() {
        try {
            Statement somethingToFind = connection.createStatement();
            ResultSet result = somethingToFind.executeQuery("SELECT 1 FROM entries WHERE word = 'abdcefgh' LIMIT 1;");

            boolean found = result.next();
            assertFalse(found, "'abdcefgh' is not in the dictionary.");
            result.close();
            somethingToFind.close();

        } catch (SQLException e) {
            e.printStackTrace();
            fail("It failed.");
        }
    }
    @Test
    public void WordCaseInsensitive() {
        try {
            Statement somethingToFind = connection.createStatement();
            ResultSet result = somethingToFind.executeQuery("SELECT 1 FROM entries WHERE LOWER(word) = LOWER('Beautiful') LIMIT 1;");
            boolean found = result.next();
            result.close();
            somethingToFind.close();
            assertTrue(found, "'Beautiful' should be found regardless of case.");
        } catch (SQLException e) {
            e.printStackTrace();
            fail("It failed.");
        }
    }




}



