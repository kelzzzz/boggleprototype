
package org.ENSEACS.core.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Edilson Alberto
// This class is used to check if a word is valid or not
public class WordChecker {
    // We need a variable that will be used in the db to check it
    private final PreparedStatement selectFindWordQuery;

    public WordChecker(Connection connection) throws SQLException {
        // This query returns the number of rows in the 'entries' table where the 'word' column matches the input word
        //  If the result is greater than 0, it means the word exists in the dictionary database.
        this.selectFindWordQuery = connection.prepareStatement("SELECT COUNT(*) FROM entries WHERE word = ?;");
    }

    // We created this method to check if the word is valid.
    // This method takes an input the specific word you want to check like Apple, Car, etc
    public boolean isValid(String word) {
        // We execute the query and check if the word is in the DB
        try {
            selectFindWordQuery.setString(1, word.toLowerCase());
            ResultSet rs = selectFindWordQuery.executeQuery();
            rs.next();
            // Return true if the count is greater than 0 (word exists), false otherwise
            return rs.getInt(1) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
