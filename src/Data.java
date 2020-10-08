//Data Interface

import java.util.ArrayList;

public interface Data {

	public void create(Employee emp);

	public ArrayList<Employee> read();

	public void update(int index, Employee newEmp);

	public void delete(int index);

	public boolean checkDuplicate(String id);
}
