package WebDriver.Example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException {

		Connection connection;

		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "Manvir1988");// Enter
																												// your
																												// Oracle
																												// SQL
																												// server
																												// password

		Statement statement = connection.createStatement();

		String query = "select * from USERSIGNUPDETAILS";

		ResultSet result;

		result = statement.executeQuery(query);

		while (result.next()) {

			String email = result.getString("signUpEmail");

			System.out.println(email);

		}

		connection.close();

	}
}
