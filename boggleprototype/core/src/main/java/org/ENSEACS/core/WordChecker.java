
package org.ENSEACS.core;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WordChecker {
    private final PreparedStatement somethingexists;

    public WordChecker(Connection connection) throws SQLException {
        this.somethingexists = connection.prepareStatement("SELECT COUNT(*) FROM entries WHERE word = ?;");
    }
    public boolean isValid(String word) {
        try {
            somethingexists.setString(1, word);
            try (ResultSet rs = somethingexists.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("DB error checking word “" + word + "”", e);
        }
    }

}
