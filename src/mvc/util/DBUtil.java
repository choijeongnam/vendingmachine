package mvc.util;
/**
 * DB ������ ���� �ε�, ����, �ݱ� ��� ����
 * */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static Properties proFile = new Properties();
	/**
	 * �ε�
	 * */
	static {
		try {
			proFile.load(new FileInputStream("resources/dbInfo.properties"));
			Class.forName(proFile.getProperty("driverName"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ����
	 * */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(proFile.getProperty("url"),
				proFile.getProperty("userName"),
				proFile.getProperty("userPass"));
		//return DriverManager.getConnection("jdbc:oracle:thin:@database-1.cvfacrkgdhm4.us-east-2.rds.amazonaws.com:1521:DATABASE", "admin", "gnstjr4596");
	}
	
	/**
	 * �ݱ�(DML�� ���)
	 * */
	public static void dbClose(Connection con, Statement st) {
		try {
			if(st!=null) st.close();
			if(con!=null) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ݱ�(SELECT�� ���)
	 * */
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			
			dbClose(con, st);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
