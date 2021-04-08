package p2;
import java.sql.*;
import java.util.Scanner;

public class inlab1 {

  public static void main(String[] args) {
    try
    { 
      Scanner sc = new Scanner(System.in);
      Connection con = null;
      Class.forName("oracle.jdbc.driver.OracleDriver");
      System.out.println("Driver class loaded");
      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ep","ep");
      System.out.println("Connection Established");
      System.out.println("Choose One Option");
      System.out.println("1. Add Item");
      System.out.println("2. Print Bill");
      int n = sc.nextInt();
      int count=0;
      if(n==1) {
    	  System.out.println("Enter no.of items to be added");
    	  int x= sc.nextInt();
    	  for(int i=0;i<x;i++) {
    	      PreparedStatement pstmt = con.prepareStatement("insert into sales values (?,?,?) ");
    	      
    	      int id;
    	      String name = null;
    	      int cost;
    	      System.out.println("Enter Item ID:");
    	      id = sc.nextInt();
    	      System.out.println("Enter Item Name:");
    	      name = sc.next();
    	      System.out.println("Enter Item Cost:");
    	      cost = sc.nextInt();
    	      pstmt.setInt(1, id);
    	      pstmt.setString(2, name);
    	      pstmt.setInt(3, cost);
    	      pstmt.execute();
    	      count++;
    	      System.out.println("Record Inserted");
    	  }
      }
      else if (n==2) {
        	  PreparedStatement pstmt = con.prepareStatement("select * from sales");
        	  ResultSet rs = pstmt.executeQuery();
        	  System.out.println("ItemId\tItemName\tCost");
        	  int sum=0;
              while(rs.next()) {
                  System.out.println(rs.getInt("itemid")+"\t"+rs.getString("itemname")+"\t\t"+rs.getInt("cost"));
                  sum=rs.getInt("cost")+sum;
              }
              System.out.println("Total Bill: "+sum);
      }

    }
    catch(Exception e)
    {
      System.out.println(e);
    }

  }

}