//Service Layer
import java.util.ArrayList;

public class Service {

	static ArrayList<Employee> list = new ArrayList<>();
	
	public static void inputEmp(String id) {
		if(Data.checkDuplicate(id)==false)
			return;
		else
			Data.create(id);
	}
	
	public static void outputEmp() {
		Data.read();
	}
	
	public static void updateEmp(String id) {
		Data.update(id);
	}
	
	public static void deleteEmp(String id) {
		Data.delete(id);
	}
	
	public static void searchEmpById(String id) {
		Data.searchById(id);
	}
	
	public static void searchEmpByName(String name) {
		Data.searchByName(name);
	}
}
