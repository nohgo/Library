package com.github.nohgo;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/COP2805";
        String username = "noh";
        String password = "hello";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.print("Database connected!\n");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) +
                                      " " + resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
