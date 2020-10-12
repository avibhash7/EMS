//Service Layer

import java.sql.SQLException;
import java.util.ArrayList;

public class Service {
	DataSql empSql = new DataSql();

	public int createEmp(String id, String name, String role) throws SQLException {
		Employee emp = new Employee(id, name, role);
		return empSql.create(emp);
	}

	public boolean checkEmp(String id) throws SQLException {
		return empSql.check(id);
	}

	public Employee readEmp(String id) throws SQLException {
		return empSql.read(id);
	}

	public ArrayList<Employee> readAllEmp() throws SQLException {
		return empSql.readAll();
	}

	public int updateEmp(String id, String name, String role) throws SQLException {
		Employee emp = new Employee(id, name, role);
		return empSql.update(emp);
	}

	public int deleteEmp(String id) throws SQLException {
		return empSql.delete(id);
	}
}
