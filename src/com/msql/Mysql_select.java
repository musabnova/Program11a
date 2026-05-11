package com.msql;

import java.sql.*;

public class Mysql_select {

    public static void main(String[] args) {

        try {

            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "musab@123sql";

            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("Successfully connected to MySQL database");

            // SELECT QUERY
            String query = "SELECT * FROM coffee";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                int id = rs.getInt("id");
                String coffee_name = rs.getString("coffee_name");
                int price = rs.getInt("price");

                System.out.println(id + " " + coffee_name + " " + price);
            }

            // INSERT QUERY
            String insertQuery =
                    "INSERT INTO coffee(coffee_name, price) VALUES('Tajmahal',950)";

            PreparedStatement pstmt = con.prepareStatement(insertQuery);

            pstmt.executeUpdate();

            System.out.println("Record inserted successfully");

            pstmt.close();
            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}