package hiveconnection;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

import au.com.bytecode.opencsv.*;



 
public class Connecttohive {
  private static String driverName = "org.apache.hive.jdbc.HiveDriver";
 
  public static void main(String[] args) throws SQLException, IOException {
    try {
    	
    	System.out.println("inside main");
      Class.forName(driverName);
      System.out.println("classfound");
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.exit(1);
    }
    Connection con = DriverManager.getConnection("jdbc:hive2://192.168.163.129:10000/default", "", "");
    Statement stmt = con.createStatement();
    System.out.println("connection establised");
    String query="";
   for(int i=0;i<args.length;i++){
    query+=args[i];
    }
    //query="select bd.race_ethnicity from bd";
    //String sql = "SELECT bd. from bd;
    System.out.println("Running: " + query);
    ResultSet res = stmt.executeQuery(query);  
    System.out.println("after query");
    CSVWriter writer = new CSVWriter(new FileWriter("C:/Users/Gaurangi/git/CancerBigDataProject/output.csv"), '\t');
    
    boolean includeHeaders=true;
	writer.writeAll(res, includeHeaders);
    
    /*while (res.next()) {
        System.out.println(String.valueOf(res.getString(0)));
      }*/
    /*while(res!=null)
    {
    	for(int i=1;i<=3;i++)
    	{
    		System.out.println("hello");
    		System.out.println(res.getDouble("stock_price_open"));
    	}
    }*/
   // String tableName = "testHiveDriverTable";
    //stmt.executeQuery("drop table " + tableName);
    //ResultSet res = stmt.executeQuery("create table " + tableName + " (key int, value string)");
    // show tables

    
  }
}