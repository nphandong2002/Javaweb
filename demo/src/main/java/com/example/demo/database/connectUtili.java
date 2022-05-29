package com.example.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectUtili {
    private  static Connection connection;

    public  static  synchronized Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/javaweb";
        String user = "root";
        String pass = "";
        if(connection == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url,user,pass);
            }catch (SQLException | ClassNotFoundException exception){
                exception.printStackTrace();
            }
        }
        return  connection;
    }
    public  static  void closeConnetion(){
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connection = null;
        }
    }
}
