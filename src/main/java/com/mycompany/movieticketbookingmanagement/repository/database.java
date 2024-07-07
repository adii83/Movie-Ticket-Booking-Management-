package com.mycompany.movieticketbookingmanagement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    public static Connection connectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/moviebook", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
