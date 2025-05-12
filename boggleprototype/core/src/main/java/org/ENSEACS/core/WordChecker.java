
package org.ENSEACS.core;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// Edilson Alberto
// This class is used to check if a word is valid or not
public class WordChecker {
    // We need a variable that will be used in the db to check it
    private final PreparedStatement somethingexists;

    public WordChecker(Connection connection) throws SQLException {
        // This query returns the number of rows in the 'entries' table where the 'word' column matches the input word
        //  If the result is greater than 0, it means the word exists in the dictionary database.
        this.somethingexists = connection.prepareStatement("SELECT COUNT(*) FROM entries WHERE word = ?;");
    }
    // We created this method to check if the word is valid.
    // This method takes an input the specific word you want to check like Apple, Car, etc
    public boolean isValid(String word) {
        try {
            somethingexists.setString(1, word);
            // We execute the query and check if the word is in the DB
            try (ResultSet rs = somethingexists.executeQuery()) {
                rs.next();
                // Return true if the count is greater than 0 (word exists), false otherwise
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("DB error checking word “" + word + "”", e);
        }
    }

}
