//Data Layer

import java.util.ArrayList;

public class DataArrayList {

	static ArrayList<Employee> list = new ArrayList<>();

	public void create(Employee emp) {
		list.add(emp);
	}

	public ArrayList<Employee> read() {
		return list;
	}

	public void update(int index, Employee newEmp) {
		list.set(index, newEmp);
	}

	public void delete(int index) {
		list.remove(index);
	}

	public boolean checkDuplicate(String id) {
		Employee emp = new Employee();
		for (Employee employee : list) {
			if (employee.getId().equals(id)) {
				emp = employee;
				break;
			}
		}
		if (list.contains(emp)) {
			return false;
		} else {
			return true;
		}
	}
}
