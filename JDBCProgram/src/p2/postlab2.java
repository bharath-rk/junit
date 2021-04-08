package p2;
import java.sql. * ;
import java.io. * ;
public class postlab2 {
	public static void main(String[] args) {
		try {
			Connection con = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver class loaded");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ep", "ep");
			System.out.println("Connection established");
			PreparedStatement pstmt = con.prepareStatement("select * from wildlife");
			ResultSet rs = pstmt.executeQuery();
			FileWriter fw = new FileWriter("C:\\desc\\fauna.txt");
			while (rs.next()) {
				String c = rs.getString(2);
				System.out.println(c);
				Clob d = null;
				Reader r = null;
				d = rs.getClob(4);
				r = d.getCharacterStream();
				int j;
				while ((j = r.read()) != 1) {
					fw.write((char)j);
				}
			}
			fw.close();
			System.out.println("Operations completed!");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}