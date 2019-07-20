package com.icss.wind.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbFactory {
    private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    public static Connection openConnection() throws Exception{
        Connection connection = tl.get();
        if(connection == null || connection.isClosed()){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","123456");
            tl.set(connection);
        }
        return connection;
    }
}
