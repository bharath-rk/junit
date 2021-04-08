package p2;
import java.sql.*;
import java.util.Scanner;

public class prelab {

  public static void main(String[] args) {
    try
    {
      Connection con = null;
      Class.forName("oracle.jdbc.driver.OracleDriver");
      System.out.println("Driver class loaded");
      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ep","ep");
      System.out.println("Connection Established");
            
      PreparedStatement pstmt = con.prepareStatement("insert into student values (?,?,?) ");
      
      int id;
      String name = null;
      int age;
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter Student ID:");
      id = sc.nextInt();
      System.out.println("Enter Student Name:");
      name = sc.next();
      System.out.println("Enter Student Age:");
      age = sc.nextInt();
      
      pstmt.setInt(1, id);
      pstmt.setString(2, name);
      pstmt.setDouble(3, age);
      
      pstmt.execute();
      System.out.println("Record Inserted");
    }
    catch(Exception e)
    {
      System.out.println(e);
    }

  }

}