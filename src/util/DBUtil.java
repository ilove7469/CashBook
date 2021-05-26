package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
	//1. DB연결을 만들어주기
	public static Connection getConnection() {
		Connection conn= null;
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "hr", password = "hr";
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, userid, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return conn;
	}
	
	
	//2. 자원반납
	public static void dbClose(ResultSet rs, Statement st, Connection conn) {
		try {
		 if(rs!=null)	rs.close();
		 if(st!=null)	st.close();
		 if(conn!=null)	conn.close();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
