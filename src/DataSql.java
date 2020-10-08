//Database

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSql {

	String dbURL = "jdbc:mysql://localhost:3307/demo";
	String username = "root";
	String password = "AviHoney";

	public void create(Employee emp) {
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			String sql = "INSERT INTO employees (id, name, role) VALUES (?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, emp.getId());
			statement.setString(2, emp.getName());
			statement.setString(3, emp.getRole());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Record added successfully!");
			}
		} catch (SQLException exc) {
			exc.printStackTrace();
		}

	}

	public void read() {
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			String sql = "select * from employees";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			System.out.println("\nID **** NAME **** ROLE\n");

			while (result.next()) {
				System.out.println(result.getNString("id") + " **** " + result.getNString("name") + " **** "
						+ result.getNString("role"));
			}

		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}

	public void update(String id, String name, String role) {
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			String sql = "UPDATE employees SET name=?, role=? WHERE id=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, role);
			statement.setString(3, id);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Record updated successfully!");
			}

		} catch (SQLException exc) {
			exc.printStackTrace();
		}

	}

	public void delete(String id) {
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			String sql = "DELETE from employees WHERE id=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Record deleted successfully!");
			}

		} catch (SQLException exc) {
			exc.printStackTrace();
		}

	}

	public void searchById(String id) {
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			String sql = "Select id, name, role from employees WHERE id=" + id;

			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				System.out.println(result.getNString("id") + " **** " + result.getNString("name") + " **** "
						+ result.getNString("role"));
			}

		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}

	public void searchByName(String name) {
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			String sql = "Select id, name, role from employees WHERE name=" + name;

			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				System.out.println(result.getNString("id") + " **** " + result.getNString("name") + " **** "
						+ result.getNString("role"));
			}

		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}
}
