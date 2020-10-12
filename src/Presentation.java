//Presentation Layer
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Presentation {

	public static void Menu() throws SQLException {

		Service empService = new Service();
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int choice;
		String id;
		String name, role;
		System.out.println("\n\n*******************************************************");
		System.out.println("***************EMPLOYEE MANAGEMENT SYSTEM**************");
		System.out.println("*****-you manage your work, we will manage your data ;)");
		do {
			System.out.println("\nMake a Choice:");
			System.out.println("1. Add Employee details");
			System.out.println("2. Read Employee details");
			System.out.println("3. Update Employee details");
			System.out.println("4. Delete Employee details");
			System.out.println("5. Display details of all the employees");
			System.out.println("6. Exit");
			System.out.println("*******************************************************");
			System.out.print("Enter your choice : ");
			choice = s.nextInt();
			s.nextLine();
			switch (choice) {
			case 1: {
					System.out.println("Enter Employee ID:");
					id = s.nextLine();
					System.out.println("Enter Employee Name:");
					name = s.nextLine();
					System.out.println("Enter Role:");
					role = s.nextLine();
					System.out.println();
					if(empService.inputEmp(id, name, role) > 0) {
						System.out.println("Record added successfully");
					};
			}
				break;
			case 2: {
				System.out.println("Enter the Employee ID to be read:");
				id = s.nextLine();
				Employee emp = empService.readEmp(id);
				System.out.println(emp.getId() + " **** " + emp.getName() + " **** " + emp.getRole());
				break;
			}
			case 3: {
				System.out.println("Enter the Employee ID whose record is to be updated:");
				id = s.nextLine();
				System.out.println("Enter new details:");
				System.out.println("Enter Employee Name:");
				name = s.nextLine();
				System.out.println("Enter Role:");
				role = s.nextLine();
				if(empService.updateEmp(id, name, role)>0) {
					System.out.println("Record updated successfully");
				};
				break;
			}
			case 4: {
				System.out.println("Enter the Employee ID whose record is to be deleted:");
				id = s.nextLine();
				if(empService.deleteEmp(id)>0) {;
					System.out.println("Record deleted successfully!");		
				}
				break;
			}
			case 5: {
				ArrayList<Employee> list = empService.readAllEmp();
				System.out.println("\nID **** NAME **** ROLE\n");
				for(Employee emp: list) {
					System.out.println(emp.getId() + " **** " + emp.getName() + " **** " + emp.getRole());
				}
				break;
			}
			case 6: {
				System.out.println("Thank you for using this system :)");
				break;
			}
			default: {
				System.out.println("Please enter a valid choice!");
				break;
			}
			}
		} while (choice != 6);
	}
}