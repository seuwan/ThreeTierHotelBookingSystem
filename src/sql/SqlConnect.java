package sql;

import java.sql.*;

public class SqlConnect {

	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/id26346966";
	public static final String DBUSER = "root";
	public static final String DBPASS = "1124";
	

	public Connection connect() throws SQLException {
		try {
			Class.forName(DBDRIVER);
			Connection connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
