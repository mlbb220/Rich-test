package rich.db;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import junit.framework.TestCase;

public class TestConnectOracle extends TestCase {

	String url="jdbc:oracle:thin:@ip:port:sid";
	String userName="";
	String password="";
	
	public void testSqlWithParameters() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {

			Connection conn = DriverManager.getConnection(
					url,
					userName, password);
			
			PreparedStatement stmt;
			String sql = "";
			sql = readFromFile("sqlFile.sql");
			int index = 1;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			java.util.Date startDate = sdf.parse("2009-08-01 10:10:01");
			java.util.Date endDate = sdf.parse("2009-08-31 10:10:01"); 
			System.out.println("start:"+startDate);
			System.out.println("end:"+endDate);
			
			System.out.println("start sql time is :" +new java.sql.Date(startDate.getTime()));
			
			stmt.setLong(index++, 86210);		
			stmt.setDate(index++, new java.sql.Date(startDate.getTime()));
			stmt.setDate(index++, new java.sql.Date(endDate.getTime()));

			stmt.setLong(index++, 86210);		
			stmt.setDate(index++, new java.sql.Date(startDate.getTime()));
			stmt.setDate(index++, new java.sql.Date(endDate.getTime()));
			
//			stmt.setQueryTimeout(360);
			// ResultSet rset =
			// stmt.executeQuery("select BANNER from SYS.V_$VERSION");
			System.out.println();
			System.out.println("sql is :"+sql);
			ResultSet rset = stmt.executeQuery();
			while (rset.next()) {
//				com.tps.eppic.CSTrxHistory cth = new com.tps.eppic.CSTrxHistory(rset,(byte)1);
//				System.out.print(cth.getAuthDateTime()+"\t");
				System.out.print(rset.getInt(1)+"\t");
				assertNotNull(rset.getTimestamp("preauth_datetime"));
				System.out.println(rset.getTimestamp("preauth_datetime"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			assertNull(e);
		}
	}

	public void testWithoutPatameter(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection(
					url,
					userName,password);
			
			Statement stmt;
			String sql = "";
			sql = readFromFile("sqlFileWithoutParm.sql");
				
			stmt = conn.createStatement();
			stmt.setQueryTimeout(360);
			// ResultSet rset =
			// stmt.executeQuery("select BANNER from SYS.V_$VERSION");
			System.out.println();
			System.out.println("sql is :"+sql);
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {
//				com.tps.eppic.CSTrxHistory cth = new com.tps.eppic.CSTrxHistory(rset,(byte)1);
//				System.out.print(cth.getAuthDateTime()+"\t");
				System.out.print(rset.getInt(1)+"\t");
				assertNotNull(rset.getTimestamp("preauth_datetime"));
				System.out.println(rset.getTimestamp("preauth_datetime"));
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			assertNull(e);
		}
	}
	
	private String readFromFile(String fileName) {
		String name = "/rich/db/" + fileName;
		String sql = "";
		String line = "";
		BufferedReader br = null;
		try {
			InputStream io = this.getClass().getResourceAsStream(name);
			br = new BufferedReader(new InputStreamReader(io));

			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				sql += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql;
	}
}
