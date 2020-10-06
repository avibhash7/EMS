//Data Layer
import java.util.ArrayList;
import java.util.Scanner;

public class Data {

    static Scanner s = new Scanner(System.in);
    static ArrayList<Employee> list = new ArrayList<>();
    
    public static void create(String id) {
    	Employee emp = new Employee();
    	String name, role;
    	System.out.println("Enter Employee Name:");
        name = s.nextLine();
        System.out.println("Enter Role:");
        role = s.nextLine();
        emp.setId(id);
		emp.setName(name);
		emp.setRole(role);
    	list.add(emp);
    }
    
    public static boolean checkDuplicate(String id) {
    	Employee emp = new Employee();
        for(Employee e: list) {
            if(e.getId().equals(id)) {
                emp=e;
                break;
            }
        }
        if(list.contains(emp)) {
       	 System.out.println("This Employee ID already exists.");
            return false;
        }
        else {
       	  return true;
        }	
	}

    public static void read() {
    	System.out.println("\nID **** NAME **** ROLE\n");
        for (Employee e : list) {
            System.out.println(e.getId()+" **** "+e.getName()+" **** "+e.getRole());
        }
        System.out.println();
    }

    public static void searchById(String id) {
        System.out.println("\nID **** NAME **** ROLE\n");
        for (Employee e : list) {
            if(e.getId().equals(id)) {
                System.out.println(e.getId() + " **** " + e.getName() + " **** " + e.getRole() + "\n");
            }
        }
    }

    public static void searchByName(String name) {
        System.out.println("\nID **** NAME **** ROLE\n");
        for (Employee e : list) {
            if(e.getName().equals(name)) {
                System.out.println(e.getId() + " **** " + e.getName() + " **** " + e.getRole() + "\n");
            }
        }
    }

    public static void update(String id) {
        String newName, newRole;
        for (Employee e : list) {
            if(e.getId().equals(id)) {
                int index = list.indexOf(e);
                System.out.println("Enter new details:");
                System.out.println("Enter Employee Name:");
                newName = s.nextLine();
                System.out.println("Enter Role:");
                newRole = s.nextLine();
                Employee newEmp = new Employee(id, newName, newRole);
                list.set(index, newEmp);
                System.out.println("Record updated Successfully!");
            }
        }
    }

    public static void delete(String id) {
        int index = 0;
        for (Employee e : list) {
            if(e.getId().equals(id)) {
                index = list.indexOf(e);
                System.out.println("Record deleted successfully!");
            }
        }
        list.remove(index);
    }
}
