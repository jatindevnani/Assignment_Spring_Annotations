package problem2.DataAccessLayer.dao;

import java.util.List;

import problem2.Beans.Employee;
import problem2.Exceptions.EmployeeException;

public interface EmployeeDao {
	public boolean insertEmployeeDetails(Employee emp);
	public List<Employee> getAllEmployeeDetails();
	public Employee findEmployee(int empId) throws EmployeeException;
	public String deleteEmployeeDetailsById(int empId) throws EmployeeException;
}
