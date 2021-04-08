package p2;
import java.sql.*;
import java.util.Scanner;

public class inlab2 {

  public static void main(String[] args) {
    try
    { 
      @SuppressWarnings("resource")
	  Scanner sc = new Scanner(System.in);
      Connection con = null;
      Class.forName("oracle.jdbc.driver.OracleDriver");
      System.out.println("Driver class loaded");
      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ep","ep");
      System.out.println("Connection Established");
      while(true) {
      System.out.println("Choose One Option");
      System.out.println("1. Add Student");
      System.out.println("2. Register Student For Workshop");
      System.out.println("3. Print All Student Details");
      System.out.println("4. Print All Students Registered For Workshop");
      System.out.println("5. Delete a Student Record From Workshop");
      System.out.println("6. Exit");
      int n = sc.nextInt();
      if(n==1) {
    	  System.out.println("Enter no.of Students Details to be added");
    	  int x= sc.nextInt();
    	  for(int i=0;i<x;i++) {
    	      PreparedStatement pstmt = con.prepareStatement("insert into studentinlab values (?,?,?,?) ");
    	      
    	      int stuid;
    	      String name = null;
    	      String mail = null;
    	      String dob = null;
    	      System.out.println("Enter Student ID:");
    	      stuid = sc.nextInt();
    	      System.out.println("Enter Student Name:");
    	      name = sc.next();
    	      System.out.println("Enter Student Mail:");
    	      mail = sc.next();
    	      System.out.println("Enter Student DOB:");
    	      dob = sc.next();
    	      pstmt.setInt(1, stuid);
    	      pstmt.setString(2, name);
    	      pstmt.setString(3, mail);
    	      pstmt.setString(4, dob);
    	      pstmt.execute();
    	      System.out.println("Record Inserted");
    	  }
      }
      else if (n==2) {
	      int stuid;
	      System.out.println("Enter Student ID:");
	      stuid = sc.nextInt();
          PreparedStatement ps = con.prepareStatement("select * from studentinlab where id=?");
          ps.setInt(1,stuid);
          ResultSet rs = ps.executeQuery();
          while(rs.next()) {
          PreparedStatement pstmt = con.prepareStatement("insert into workshop values (?,?,?,?)");
	      pstmt.setInt(1, stuid);
	      pstmt.setString(2, rs.getString("name"));
	      pstmt.setString(3, rs.getString("mail"));
	      pstmt.setString(4, rs.getString("dob"));
	      pstmt.execute();
	      }
          System.out.println("Student Registration for Workshop is Done");
      }
      else if (n==3) {
    	  PreparedStatement pstmt = con.prepareStatement("select * from studentinlab");
    	  ResultSet rs = pstmt.executeQuery();
    	  System.out.println("Student Details");
          while(rs.next()) {
              System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getString("mail")+"\t"+rs.getString("dob"));
          }
      }
      else if (n==4) {
    	  PreparedStatement pstmt = con.prepareStatement("select * from workshop");
    	  ResultSet rs = pstmt.executeQuery();
    	  System.out.println("Student Details Registered for Workshops");
          while(rs.next()) {
              System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getString("mail")+"\t"+rs.getString("dob"));
          }
      }
      else if (n==5) {
	      int stuid;
	      System.out.println("Enter Student ID:");
	      stuid = sc.nextInt();
          PreparedStatement pstmt = con.prepareStatement("delete from workshop where id=?");
          pstmt.setInt(1,stuid);
    	  pstmt.execute();
    	  System.out.println("Student Unregistered");
      }
      else {
    	  System.exit(0);
      }
      }

    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}