package problem2.PresentationLayer;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import antlr.collections.List;
import problem2.Beans.Employee;
import problem2.Exceptions.EmployeeException;
import problem2.ServiceLayer.EmployeeServiceImpl;

@Controller
public class PresentationBean {

	@Autowired
	private EmployeeServiceImpl service;
	
	public void showAllEmployees() {
		
		ArrayList<Employee> employees = (ArrayList<Employee>) service.getAllEmployee();
		
		for(Employee emp: employees) {
			System.out.println(emp);
		}
	}
	
	public void deleteEmployee() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Give the ID of the Employee you want to delete - ");
		int id = scanner.nextInt();
		try {
			service.deleteEmployeeById(id);
			System.out.println("Deleted successfully!");
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		
	}
	
	public Employee findEmployee() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Give the ID of the Employee you want to Fetch - ");
		int id = scanner.nextInt();
		Employee employee = null;
		try {
			employee = service.getEmployeeById(id);
			
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		
		return employee;
	}
	
	public void AddEmployee() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Give the name of the employee you want to add: ");
		String name = scanner.next();
		System.out.println("Give the address: ");
		String address = scanner.next();
		System.out.println("Give the salary: ");
		int salary = scanner.nextInt();
		
		Employee employee = new Employee();
		employee.setEmpName(name);
		employee.setEmpAddress(address);
		employee.setSalary(salary);
		
		service.saveEmployee(employee);
	}
	
	
}
