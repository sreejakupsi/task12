package jbbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Task12TJDBCConnectionClass {

	public static void main(String[] args) {
		// Connection details
		String db_url = "jdbc:mysql://localhost:3306";
		String username = "root";
		String password = "Root";

		// Establish the connection
		try {
			Connection connection = DriverManager.getConnection(db_url, username, password);
			Statement smt = connection.createStatement();

			// Perform operation
			String createDB = "create database DetailsOfEmpl_JDBC";
			smt.execute(createDB);
			String useDB = "use DetailsOfEmpl_JDBC";
			smt.execute(useDB);
			String createTable = "create table DetailsOfEmpl_JDBC(empcod INT UNIQUE, empname VARCHAR(15),empag INT,esalary DOUBLE)";
			smt.execute(createTable);
			String insertValues = "INSERT INTO DetailsOfEmpl_JDBC (empcod, empname, empag, esalary) VALUES "
					+ "(101, 'JENNY', 25, 10000), " + "(102, 'JACKY', 30, 20000), " + "(103, 'JOE', 20, 40000), "
					+ "(104, 'JOHN', 40, 80000), " + "(105, 'Shameer', 25, 90000) ";
			smt.executeUpdate(insertValues);
			String select = "Select * from DetailsOfEmpl_JDBC";
			ResultSet result = smt.executeQuery(select);

			while (result.next()) {
				int empcod = result.getInt("empcod");
				String empname = result.getString("empname");
				int empag = result.getInt("empag");
				double esalary = result.getDouble("esalary");
				System.out.println(
						"Emp Code: " + empcod + ", Name: " + empname + ", Age: " + empag + ", Salary: " + esalary);
			}

			// Close connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
