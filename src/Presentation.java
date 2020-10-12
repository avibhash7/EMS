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
				try {
					System.out.println("Enter Employee ID:");
					id = s.nextLine();
					if (empService.checkEmp(id) == true) {
						System.out.println("The entered Employee ID already exists");
					} else {
						System.out.println("Enter Employee Name:");
						name = s.nextLine();
						System.out.println("Enter Role:");
						role = s.nextLine();
						System.out.println();
						if (empService.createEmp(id, name, role) > 0) {
							System.out.println("Record added successfully");
						}
					}
				} catch (SQLException sqlex) {
					System.out.print(sqlex.getMessage());
				}

			}
				break;
			case 2: {
				try {
					System.out.println("Enter the Employee ID to be read:");
					id = s.nextLine();
					if (empService.checkEmp(id) == false) {
						System.out.println("The entered Employee ID does not exist");
					} else {
						Employee emp = empService.readEmp(id);
						System.out.println(emp.getId() + " **** " + emp.getName() + " **** " + emp.getRole());
					}

				} catch (SQLException sqlex) {
					System.out.print(sqlex.getMessage());
				}
				break;
			}
			case 3: {
				try {
					System.out.println("Enter the Employee ID whose record is to be updated:");
					id = s.nextLine();
					if (empService.checkEmp(id) == false) {
						System.out.println("The entered Employee ID does not exist");
					} else {
						System.out.println("Enter new details:");
						System.out.println("Enter Employee Name:");
						name = s.nextLine();
						System.out.println("Enter Role:");
						role = s.nextLine();
						if (empService.updateEmp(id, name, role) > 0) {
							System.out.println("Record updated successfully");
						}
					}
				} catch (SQLException sqlex) {
					System.out.print(sqlex.getMessage());
				}
				break;
			}
			case 4: {
				try {
					System.out.println("Enter the Employee ID whose record is to be deleted:");
					id = s.nextLine();
					if (empService.checkEmp(id) == false) {
						System.out.println("The entered Employee ID does not exist");
					} else {
						if (empService.deleteEmp(id) > 0) {
							System.out.println("Record deleted successfully!");
						}
					}
				} catch (SQLException sqlex) {
					System.out.print(sqlex.getMessage());
				}
				break;
			}
			case 5: {
				try {
					ArrayList<Employee> list = empService.readAllEmp();
					System.out.println("\nID **** NAME **** ROLE\n");
					for (Employee emp : list) {
						System.out.println(emp.getId() + " **** " + emp.getName() + " **** " + emp.getRole());
					}
				} catch (SQLException sqlex) {
					System.out.print(sqlex.getMessage());
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