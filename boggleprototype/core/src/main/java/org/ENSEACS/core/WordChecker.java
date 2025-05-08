
package org.ENSEACS.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WordChecker {
    private final Connection connection;

    public WordChecker(Connection connection){
        this.connection = connection;
    }


}
