//Presentation Layer
import java.util.Scanner;

public class Presentation {
	
    public static void Menu() {
    	
    	Service empService = new Service();
    	Scanner s = new Scanner(System.in);
    	Employee emp = new Employee();
    	int choice;
        String id;
        String name, role;
        System.out.println("\n\n*******************************************************");
        System.out.println("***************EMPLOYEE MANAGEMENT SYSTEM**************");
        System.out.println("*****-you manage your work, we will manage your data ;)\n");
        do {
        System.out.println("Make a Choice:");
        System.out.println("1. Add Employee details");
        System.out.println("2. Show details of all the employees");
        System.out.println("3. Search for an Employee");
        System.out.println("4. Update Employee details");
        System.out.println("5. Delete Employee details");
        System.out.println("6. Exit");
        System.out.println("*******************************************************");
        System.out.print("Enter your choice : ");
        choice = s.nextInt();
        s.nextLine();
        switch(choice) {
            case 1: {
            	System.out.println("Enter Employee ID:");
                id = s.nextLine();
                Service.inputEmp(id);
            }
            	break;
            case 2: {
                Service.outputEmp();
                break;
            }
            case 3: {
                System.out.println("1. Search By Employee ID");
                System.out.println("2. Search be Employee name");
                System.out.println("Enter your choice:");
                int ch = s.nextInt();
                s.nextLine();
                switch(ch) {
                    case 1: {
                        System.out.println("Enter the Employee ID to be searched:");
                        id = s.nextLine();
                        Service.searchEmpById(id);
                        break;
                    }
                    case 2: {
                        System.out.println("Enter the Employee name to be searched:");
                        name = s.nextLine();
                        Service.searchEmpByName(name);
                        break;
                    }
                    default: {
                        System.out.println("Incorrect choice!");
                    }
                }
                break;
            }
            case 4: {
                System.out.println("Enter the Employee ID whose record is to be updated:");
                id = s.nextLine();
                Service.updateEmp(id);
                break;
            }
            case 5: {
                System.out.println("Enter the Employee ID whose record is to be deleted:");
                id = s.nextLine();
                Service.deleteEmp(id);
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