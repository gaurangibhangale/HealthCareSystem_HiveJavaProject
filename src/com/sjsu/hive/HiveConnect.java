package com.sjsu.hive;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
 
public class HiveConnect {
  private static String driverName = "org.apache.hive.jdbc.HiveDriver";
 
  public static void main(String[] args) throws SQLException {
    try {
      Class.forName(driverName);
      System.out.println("classfound");
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.exit(1);
    }
    Connection con = DriverManager.getConnection("jdbc:hive2://192.168.206.128:10000", "hue", "1111");
   // Statement stmt = con.createStatement();
    String tableName = "testHiveDriverTable";
    //stmt.executeQuery("drop table " + tableName);
   // ResultSet res = stmt.executeQuery("create table " + tableName + " (key int, value string)");
    // show tables

    
  }
}