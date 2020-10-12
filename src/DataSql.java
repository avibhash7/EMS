//Database

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataSql {

	public int create(Employee emp) throws SQLException{
			Connection conn = DatabaseConnection.getConn();
			
			String sql = "Insert into employees values('"+emp.getId()+"','"+emp.getName()+"','"+emp.getRole()+"')";
			PreparedStatement statement = conn.prepareStatement(sql);
			return statement.executeUpdate();
	}
	
	public Employee read(String id) throws SQLException {
		Connection conn = DatabaseConnection.getConn();
		String sql = "Select id, name, role from employees WHERE id=" + id;
		
		Employee emp = new Employee();
		PreparedStatement statement = conn.prepareStatement(sql);

		ResultSet result = statement.executeQuery(sql);
		emp.id = id;
		while (result.next()) {
            emp.setName(result.getString("name"));
            emp.setRole(result.getString("role"));
		}
		return emp;
	}

	public ArrayList<Employee> readAll() throws SQLException {
		
			Connection conn = DatabaseConnection.getConn();
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
			Connection conn = DatabaseConnection.getConn();
			String sql = "UPDATE employees SET name='" + emp.getName() + "', role='" + emp.getRole() + "' WHERE id=" + emp.getId();
			
			PreparedStatement statement = conn.prepareStatement(sql);
			return statement.executeUpdate();	
	}

	public int delete(String id) throws SQLException {
		
			Connection conn = DatabaseConnection.getConn();
			String sql = "DELETE from employees WHERE id=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			return statement.executeUpdate();		
	}
}
