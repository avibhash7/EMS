//Data Interface

import java.sql.SQLException;
import java.util.ArrayList;

public interface Data {

	public int create(Employee emp) throws SQLException;

	public boolean check(String id) throws SQLException;

	public Employee read(String id) throws SQLException;

	public ArrayList<Employee> readAll() throws SQLException;

	public int update(Employee emp) throws SQLException;

	public int delete(String id) throws SQLException;
}
