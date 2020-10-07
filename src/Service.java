//Service Layer
import java.util.ArrayList;
import java.util.Scanner;

public class Service {

	Data empData = new Data();
	static ArrayList<Employee> list;
	Scanner s = new Scanner(System.in);
	
	public boolean check(String id) {
		if(empData.checkDuplicate(id)==false) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void inputEmp(String id, String name, String role) {
		Employee emp = new Employee(id, name, role);
		empData.create(emp);
	}
	
	public void outputEmp() {
		System.out.println("\nID **** NAME **** ROLE\n");
		list = empData.read();
		for (Employee e : list) {
			System.out.println(e.getId() + " **** " + e.getName() + " **** " + e.getRole());
		}
	}
	
	public void updateEmp(String id) {
		list = empData.read();
		String newName, newRole;
		int index = 0;
		for (Employee e : list) {
			if(e.getId().equals(id)) {
				index = list.indexOf(e);
				System.out.println("Enter new details:");
				System.out.println("Enter Employee Name:");
				newName = s.nextLine();
				System.out.println("Enter Role:");
				newRole = s.nextLine();
				Employee newEmp = new Employee(id, newName, newRole);
				empData.update(index, newEmp);
				System.out.println("Record updated Successfully!");
			}
		}
		if(index == 0) {
			System.out.println("Record not found!");
		}
	}
	
	public void deleteEmp(String id) {
		list = empData.read();
		int found = 0;
		for (Employee e : list) {
			if(e.getId().equals(id)) {
				int index = list.indexOf(e);
				found = 1;
				empData.delete(index);
				System.out.println("Record deleted successfully!");
				break;
			}
		}
		if(found == 0) {
			System.out.println("Record not found!");
		}
	}
	
	public void searchEmpById(String id) {
		list = empData.read();
		int index = 0;
		for (Employee e : list) {
			if(e.getId().equals(id)) {
				index = 1;
				System.out.println("\nID **** NAME **** ROLE\n");
				System.out.println(e.getId() + " **** " + e.getName() + " **** " + e.getRole());
			}
		}
		if(index == 0) {
			System.out.println("Record not found!");
		}
	}
	
	public void searchEmpByName(String name) {
		list = empData.read();
		int index = 0;
		for (Employee e : list) {
			if(e.getName().equals(name)) {
				index = 1;
				System.out.println("\nID **** NAME **** ROLE\n");
				System.out.println(e.getId() + " **** " + e.getName() + " **** " + e.getRole());
			}
		}
		if(index ==0) {
			System.out.println("Record not found!");
		}
	}
}

