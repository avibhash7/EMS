//Service Layer

import java.util.Scanner;

public class Service {

	DataArrayList empData = new DataArrayList();

	DataSql empSql = new DataSql();

	Scanner s = new Scanner(System.in);

	public boolean check(String id) {
		if (empData.checkDuplicate(id) == false) {
			return false;
		} else {
			return true;
		}
	}

	public void inputEmp(String id, String name, String role) {
		Employee emp = new Employee(id, name, role);
		empSql.create(emp);
	}

	public void outputEmp() {
		empSql.read();
	}

	public void updateEmp(String id) {
		String newName, newRole;
		System.out.println("Enter new details:");
		System.out.println("Enter Employee Name:");
		newName = s.nextLine();
		System.out.println("Enter Role:");
		newRole = s.nextLine();
		empSql.update(id, newName, newRole);
	}

	public void deleteEmp(String id) {
		empSql.delete(id);
	}

	public void searchEmpById(String id) {
		empSql.searchById(id);
	}

	public void searchEmpByName(String name) {
		empSql.searchByName(name);
	}
}
