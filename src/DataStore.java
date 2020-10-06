//Data Layer
import java.util.ArrayList;
import java.util.Scanner;


public class DataStore {

    Scanner s = new Scanner(System.in);
    ArrayList<Employee> list = new ArrayList<>();
    String id, name, role;

    public void inputDetails() {
        System.out.println("Enter Employee ID:");
        id = s.nextLine();
        Employee emp = new Employee();
        for(Employee e: list) {
            if(e.getId().equals(id)) {
                emp=e;
                break;
            }
        }
        if(list.contains(emp)) {
            System.out.println("Employee with this ID already exists!");
            return;
        }
        else {
            emp.setId(id);
        }
        System.out.println("Enter Employee Name:");
        name = s.nextLine();
        emp.setName(name);
        System.out.println("Enter Role:");
        role = s.nextLine();
        emp.setRole(role);
        list.add(new Employee(id, name, role));
    }

    public void outputDetails() {
        System.out.println("\nID **** NAME **** ROLE\n");
        for (Employee e : list) {
            System.out.println(e.getId()+" **** "+e.getName()+" **** "+e.getRole());
        }
        System.out.println();
    }

    public void searchById(String id) {
        System.out.println("\nID **** NAME **** ROLE\n");
        for (Employee e : list) {
            if(e.getId().equals(id)) {
                System.out.println(e.getId() + " **** " + e.getName() + " **** " + e.getRole() + "\n");
            }
        }
    }

    public void searchByName(String name) {
        System.out.println("\nID **** NAME **** ROLE\n");
        for (Employee e : list) {
            if(e.getName().equals(name)) {
                System.out.println(e.getId() + " **** " + e.getName() + " **** " + e.getRole() + "\n");
            }
        }
    }

    public void updateDetails(String id) {
        String newId, newName, newRole;
        for (Employee e : list) {
            if(e.getId().equals(id)) {
                //searchById(id);
                int index = list.indexOf(e);
                System.out.println("Enter new details:");
                //inputDetails();
                System.out.println("Enter Employee ID:");
                newId = s.nextLine();
                System.out.println("Enter Employee Name:");
                newName = s.nextLine();
                System.out.println("Enter Role:");
                newRole = s.nextLine();
                Employee newEmp = new Employee(newId, newName, newRole);
                list.set(index, newEmp);
                System.out.println("Record updated Successfully!");
            }
        }
    }

    public void deleteDetails(String id) {
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
