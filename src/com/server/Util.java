package com.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {


    private Connection conn;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/examdb?useSSL=false&serverTimezone=UTC";
    private String username = "root";
    private String password = "mysql123";
    public Util(){

        try
        {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url, username, password);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public Connection getConnection()
    {
        return this.conn;
    }

    public static void main(String[] args)
    {
        Util dc = new Util();
        dc.getConnection();
        System.out.print("连接数据库成功");
    }
}



