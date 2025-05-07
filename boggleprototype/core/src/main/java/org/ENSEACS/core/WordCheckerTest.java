package org.ENSEACS.core;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class WordCheckerTest {

    static Connection connection;
    static WordChecker checkingword;

    @BeforeAll
    public static void setup() throws SQLException {

        connection = Databaseloader.loadToMyMemoryDB();
        checkingword = new WordChecker(connection);
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
    void testifCarIsValid() {
        assertTrue(checkingword.isValid("car"));
    }
    @Test
    void testifCrazyIsValid(){
        assertTrue(checkingword.isValid("crazy"));
    }
    @Test
    void testforInvalidWord() {
        assertFalse(checkingword.isValid("abcdefgh"));
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



