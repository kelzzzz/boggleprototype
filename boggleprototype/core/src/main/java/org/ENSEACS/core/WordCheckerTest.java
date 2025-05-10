package org.ENSEACS.core;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
// Edilson Alberto
// This class has our JUNIT Tests that run different test to check if our code is working perfectly
public class WordCheckerTest {

    static Connection connection;
    static WordChecker checkingword;

    @BeforeAll
    public static void setup() throws SQLException {
        // We establish a Connection with the database and we call our method, LoadtoMyMEMORY
        connection = Databaseloader.loadToMyMemoryDB();
        // This variable will help us using our Word Checker class to check certain words
        checkingword = new WordChecker(connection);
    }
    @Test
    // This test checks if the Connection to the database is valid, in other words, if it can find the file and connect to it and also read it
    // This test is very important, because if it doesn't pass, the other won't
    // Because we depend on the connection to read the file
    public void testDatabaseConnectionIsValid() {
        try {
            // We use assertTrue because we expect it to be true
            assertTrue(connection.isValid(1), "Database connection is not valid.");
            System.out.println("Connection to database is a success");
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Exception while validating connection.");
        }
    }
    // This test uses wordchecker to test if Car is a valid word / is in the database
    // If this test passes, this means, the word car is in the database
    @Test
    void testifCarIsValid() {
        assertTrue(checkingword.isValid("car"));
    }
    // This test uses wordchecker to test if crazy is a valid word / is in the database
    // If this test passes, this means, the word crazy is in the database
    @Test
    void testifCrazyIsValid(){
        assertTrue(checkingword.isValid("crazy"));
    }
    // We test if the code can recognize words that aren't on the dictionary
    // We expect words that are not in the dictionary, to be left out
    // We expect the code to alert us once it detects
    @Test
    void testforInvalidWord() {
        assertFalse(checkingword.isValid("abcdefgh"));
    }
    // This test makes us sure that even if you write the word with capital letter, it will still recognize the word and check
    // if is in the database
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



