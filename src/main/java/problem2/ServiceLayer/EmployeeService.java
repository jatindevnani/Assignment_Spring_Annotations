package problem2.ServiceLayer;

import java.util.List;

import problem2.Beans.Employee;
import problem2.Exceptions.EmployeeException;

public interface EmployeeService {
	public Employee saveEmployee(Employee emp);
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int empId)throws EmployeeException;
	public String deleteEmployeeById(int empId)throws EmployeeException;
}
