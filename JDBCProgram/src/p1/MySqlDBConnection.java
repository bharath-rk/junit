package p1;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDBConnection {

  public static void main(String[] args) {
    try {
      Connection con = null;
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver Class Loaded");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practical5?useSSL=false", "root", "trio");
      System.out.println("Connection Established");    
    }
    catch(Exception e) {
      System.out.println(e);
    }

  }

}
