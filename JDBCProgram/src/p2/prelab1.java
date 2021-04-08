package p2;
import java.sql.*;
import java.util.*;
import java.util.Scanner;

public class prelab1 {

  public static void main(String[] args) {
    try
    { Scanner sc = new Scanner(System.in);
      Connection con = null;
      Class.forName("oracle.jdbc.driver.OracleDriver");
      System.out.println("Driver class loaded");
      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ep","ep");
      System.out.println("Connection Established");
      System.out.println("Enter 1 to print all student details");
      System.out.println("Enter 2 to print student details whose age < 21");
      int n=sc.nextInt();
      PreparedStatement pstmt = null;
      if(n==1) {
      pstmt = con.prepareStatement("select * from student"); 	  
      }
      else {
      pstmt = con.prepareStatement("select * from student where age < 21");
      }
      ResultSet rs = pstmt.executeQuery();

      int count = 1;
      while(rs.next()) {
        System.out.println("Employee Record - "+count);
        System.out.println("Student ID:" +rs.getInt("id"));
        System.out.println("Student Name:" +rs.getString("name"));
        System.out.println("Student Age:" +rs.getInt("age"));
        count = count+1;
        System.out.println("");
      }

    }
    catch(Exception e)
    {
      System.out.println(e);
    }

  }

}
