package mysqldeneme;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Mysql {

	static final String DB = "jdbc:mysql://localhost:3306/ogrenci";
	static final String USER = "root";
	static final String PASS = "rott";
	static final String QUERY = "SELECT*FROM kayit" + " WHERE ad='Ali'";

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(DB, USER, PASS);
		Statement st = con.createStatement();
		System.out.println("Veri tabanina baglandi");

		System.out.println(" VERI TABANINDA ARADIGINIZ YASI GIRINIZ:");
		Scanner i = new Scanner(System.in);
		int old = i.nextInt();
		
		String sql = "SELECT*FROM kayit" + " WHERE yas="+old+"";

		/*
		 * String sql="INSERT INTO kayit Values(106,'Mustafa','Ali',20)";
		 * st.executeUpdate(sql); String
		 * sql2="CREATE TABLE KAYİT "+"(id INTEGER notNULL, "+
		 * "ad VARCHAR(60), "+"soyadi(60), "+"yas INTEGER, "+ "PRIMERY KEY(id)";
		 * 
		 * st.executeUpdate(sql2);
		 */

		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			System.out.print(" ID: " + rs.getInt("id"));
			System.out.print(" YAS: " + rs.getInt("yas"));
			System.out.print(" AD: " + rs.getString("ad"));
			System.out.println(" SOYADI: " + rs.getString("soyadi"));

		}
		rs.close();

	}

}
