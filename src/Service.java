//Service Layer

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Service {

	DataArrayList empData = new DataArrayList();

	DataSql empSql = new DataSql();

	Scanner s = new Scanner(System.in);

	public int inputEmp(String id, String name, String role) throws SQLException {
		Employee emp = new Employee(id, name, role);
		return empSql.create(emp);
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
