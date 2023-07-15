package com.example.demo1;

import java.sql.*;
import java.sql.ResultSet;

public class Movie {
    int price;
    int duration;
    String name;
    String category;

    public Movie(int pricen, int durationn, String namen, String categoryn) {
        price = pricen;
        duration = durationn;
        name = namen;
        category = categoryn;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public static void getMovies(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM movies");
        System.out.println(rs);
        while (rs.next()) {
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("category"));
            System.out.println(rs.getString("price"));
            System.out.println(rs.getString("duration"));
        }
    }

    public static void addMovies(Connection con,String name,String category,String price,String duration) throws SQLException {
        if (name == "")
            System.out.println("Input Vaild Name");
        if (category == "")
            System.out.println("Input Valid Category");
        if (price == "")
            System.out.println("Input Valid price");
        if (duration == "")
            System.out.println("Input Valid duration");
        else {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO movies (name, category, price, duration) VALUES (" + "'" + name + "'" + ", " + "'" + category + "'" + ", " + price + ", " + duration + ")");
            System.out.println("Executed operation -> " + "INSERT INTO movies (name, category, price, duration) VALUES (" + "'" + name + "'" + "'" + ", " + "'" + category + "'" + ", " + price + ", " + duration + ")");
        }
    }
    
}
