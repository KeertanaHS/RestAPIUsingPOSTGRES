/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Keertana H S
 * 
 */
public class DBClass {
        
    public static Connection getConnection(){
        Connection conn = null;
        try {
            /*Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres","postgres", "root");*/
            
            /*Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://eec2-54-235-94-236.compute-1.amazonaws.com:5432/d4vpd3oiivamqr?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory&searchpath=webresto",
             "User\n" +
                "dhqxuzuezjrmqx", "qwgnSsOjCFyP9TDG82kUO2kie4");*/
            
            /*Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://ec2-54-235-94-236.compute-1.amazonaws.com:5432/d4vpd3oiivamqr?sslmode=require&user=dhqxuzuezjrmqx&password=qwgnSsOjCFyP9TDG82kUO2kie4");*/
            
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://ec2-54-235-94-236.compute-1.amazonaws.com:5432/d4vpd3oiivamqr?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory&searchpath=webresto",
           "dhqxuzuezjrmqx", "qwgnSsOjCFyP9TDG82kUO2kie4");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static void clossConnection(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String [] args){
    
    Connection conn = DBClass.getConnection();
        try {
            System.out.println(">>>>>>>>>>>>>>   "+conn.isClosed());
            DBClass.clossConnection(conn);
            System.out.println(">>>>>........>>>>>>>>>   "+conn.isClosed());
            
        } catch (SQLException ex) {
            Logger.getLogger(DBClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
                    
}
