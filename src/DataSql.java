//Database

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataSql {

	Connection conn = DatabaseConnection.getConn();

	public int create(Employee emp) throws SQLException {
		String sql = "Insert into employees values(?,?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, emp.getId());
		statement.setString(2, emp.getName());
		statement.setString(3, emp.getRole());

		return statement.executeUpdate();
	}

	public boolean check(String id) throws SQLException {

		boolean idExists = false;
		String sql = "select * from employees where id = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, id);

		ResultSet result = statement.executeQuery();
		if (result.next()) {
			idExists = true;
		}
		return idExists;
	}

	public Employee read(String id) throws SQLException {

		String sql = "Select id, name, role from employees WHERE id=?";

		Employee emp = new Employee();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, id);

		ResultSet result = statement.executeQuery();

		emp.id = id;
		while (result.next()) {
			emp.setName(result.getString("name"));
			emp.setRole(result.getString("role"));
		}
		return emp;
	}

	public ArrayList<Employee> readAll() throws SQLException {

		String sql = "select * from employees";
		ArrayList<Employee> list = new ArrayList<>();
		Statement statement = conn.createStatement();

		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			Employee emp = new Employee(result.getString("id"), result.getString("name"), result.getString("role"));
			list.add(emp);
		}

		return list;
	}

	public int update(Employee emp) throws SQLException {

		String sql = "UPDATE employees SET name=?, role=? WHERE id =?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, emp.getName());
		statement.setString(2, emp.getRole());
		statement.setString(3, emp.getId());

		return statement.executeUpdate();
	}

	public int delete(String id) throws SQLException {

		String sql = "DELETE from employees WHERE id=?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, id);

		return statement.executeUpdate();
	}
}