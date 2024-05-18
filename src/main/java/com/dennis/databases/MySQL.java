package com.dennis.databases;

import com.dennis.Init;
import static com.dennis.utils.Logging.LOGGER;
import java.sql.*;
import java.util.logging.Level;

/**
 *
 * @author DennisMutethia
 */
public class MySQL {

    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + Init.APPLICATION_PROPERTIES.getProperty("db_name"),
                    Init.APPLICATION_PROPERTIES.getProperty("db_user"),
                    Init.APPLICATION_PROPERTIES.getProperty("db_user_password")
            )) {
                Statement stmt = con.createStatement();
                String query = "SELECT * FROM `employees`";
                System.out.println("Executing query: " + query);
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.println(
                            "id: " + id
                            + "\nname: " + name
                            + "\nage: " + age
                    );
                    System.out.println("---------------");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.log(Level.SEVERE, "{0}", e);
        } 
    }

}
