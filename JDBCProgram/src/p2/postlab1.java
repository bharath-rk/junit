package p2;
import java.util.*;
import java.sql.*;
import java.io.*;
public class postlab1 {
    public static void main(String[] args) {
            try {
                Connection con = null;
                Class.forName("oracle.jdbc.driver.OracleDriver");
                System.out.println("Driver class loaded");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ep","ep");
                        System.out.println("Connection Established"); 
                        System.out.println("Enter Number of records you want to enter:");
                            Scanner sc = new Scanner(System.in); 
                            int n = sc.nextInt(); 
                            int m = n; 
                            String name; 
                            String ctg; 
                            File img; 
                            File desc;
                            while (n != 0) {
                                System.out.println("Enter name of species: ");
                                name = sc.next();
                                System.out.println("Enter category of species(flora/fauna): ");
                                ctg = sc.next();
                                System.out.println("Enter path for image of species:");
                                    img = new File(sc.next());
                                    FileReader fr = new FileReader(img); 
                                    FileInputStream fs = new FileInputStream(img);
                                    System.out.println("Enter path for description of species: "); 
                                    desc = new File(sc.next()); 
                                    FileReader fr1 = new FileReader(desc); 
                                    FileInputStream fs1 = new FileInputStream(desc); 
                                    PreparedStatement pstmt = con.prepareStatement("insert into wildlife values(?,?,?,?)"); 
                                    pstmt.setString(1, name); 
                                    pstmt.setString(2, ctg); 
                                    pstmt.setBinaryStream(3, fs, (int) img.length());
                                    pstmt.setCharacterStream(4, fr, (int) desc.length());
                                    pstmt.execute(); 
                                    System.out.println("Record inserted"); 
                                    n -= 1;
                                }
                                System.out.println(m + " records are inserted in wildlifetable ");
                                }
                                catch (Exception e) {
                                    System.out.println(e);
                                }
                            }
                        }