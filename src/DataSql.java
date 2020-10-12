//Database

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSql {

	
	DbConnection empConnect = new DbConnection();
	
	String dbURL = "jdbc:mysql://localhost:3307/demo";
	String username = "root";
	String password = "AviHoney";

	public void create(Employee emp) throws SQLException{
		
			Connection conn = empConnect.getConn();
			String sql = "INSERT INTO employees (id, name, role) VALUES (?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, emp.getId());
			statement.setString(2, emp.getName());
			statement.setString(3, emp.getRole());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Record added successfully!");
			}

	}
	
	public void read(String id) throws SQLException {
		Connection conn = empConnect.getConn();
		String sql = "Select id, name, role from employees WHERE id=" + id;

		PreparedStatement statement = conn.prepareStatement(sql);

		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			System.out.println(result.getString("id") + " **** " + result.getString("name") + " **** "
					+ result.getString("role"));
		}
	}

	public void readAll() throws SQLException {
			
			Connection conn = empConnect.getConn();
			String sql = "select * from employees";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			System.out.println("\nID **** NAME **** ROLE\n");

			while (result.next()) {
				System.out.println(result.getString("id") + " **** " + result.getString("name") + " **** "
						+ result.getString("role"));
			}
	}

	public void update(String id, String name, String role) throws SQLException {
			Connection conn = empConnect.getConn();
			String sql = "UPDATE employees SET name=?, role=? WHERE id=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, role);
			statement.setString(3, id);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Record updated successfully!");
			}
	}

	public void delete(String id) throws SQLException {
		
			Connection conn = empConnect.getConn();
			String sql = "DELETE from employees WHERE id=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Record deleted successfully!");
			}

	}
}
