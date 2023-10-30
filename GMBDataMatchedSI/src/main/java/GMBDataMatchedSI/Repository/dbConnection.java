package GMBDataMatchedSI.Repository;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class dbConnection {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/siqa_02"+"?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";


	// Database credentials
	static final String USER = "root";
	static final String PASS = "MysqlSiAdmin";
static Connection conn = null;
static Statement stmt = null;
static LocalDateTime date = LocalDateTime.now();
static LocalDateTime Previousdate = LocalDateTime.now().minusDays(1);
//static String projectName = "Bharat.Shop";

public void database(String urls,String Status) throws ClassNotFoundException {

	System.out.println(date);
	try {
		Class.forName(JDBC_DRIVER);

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			String sql = "insert into siqa_02.apijson (urls, status, date) values ('"
					+ urls + "','" + Status + "', '" + date + "')";

			stmt.executeUpdate(sql);
			conn.close();
			stmt.close();
		} catch (SQLException ex) {
			stmt.close();
			conn.close();
		}
	} catch (SQLException e) {
		e.printStackTrace();

	}
}

}