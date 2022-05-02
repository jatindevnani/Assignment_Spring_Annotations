package problem2.Driver;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import antlr.collections.List;
import problem2.Beans.Employee;
import problem2.Configuration.AppConfig;
import problem2.DataAccessLayer.dao.EmployeeDaoImpl;
import problem2.Exceptions.EmployeeException;
import problem2.PresentationLayer.PresentationBean;
import problem2.ServiceLayer.EmployeeService;
import problem2.ServiceLayer.EmployeeServiceImpl;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		PresentationBean presentation = context.getBean(PresentationBean.class);
		
		//Adding the employee
		presentation.AddEmployee();
		
		//Deleting the employee
		presentation.deleteEmployee();
		
		//Listing all employees
		presentation.showAllEmployees();
		
		//Finding a specific employee
		Employee employee = presentation.findEmployee();
		System.out.println(employee);
	}

}
