package org.ENSEACS.core;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class WordCheckerTest {

    static WordChecker checkingforConn;
    static Connection connection;

    @BeforeAll
    public static void setup() {

        connection = Databaseloader.loadToMyMemoryDB();
    }
    @Test
    public void testDatabaseConnectionIsNotNull() {
        assertNotNull(connection, "Connection to the in-memory DB failed!");
        System.out.println("Connected to database successfully.");
    }



}
