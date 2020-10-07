//Data Layer
import java.util.ArrayList;

public class Data {

    static ArrayList<Employee> list = new ArrayList<>();

    public void create(Employee emp) {
    	list.add(emp);
    }

    public ArrayList<Employee> read() {
        return list;
    }

    public boolean checkDuplicate(String id) {
    	Employee emp = new Employee();
        for(Employee e: list) {
            if(e.getId().equals(id)) {
                emp=e;
                break;
            }
        }
        if(list.contains(emp)) {
            return false;
        }
        else {
       	  return true;
        }
	}

    public void update(int index, Employee newEmp) {
        list.set(index, newEmp);
    }

    /*public void delete(int index) {
        list.remove(index);
    }*/
}
