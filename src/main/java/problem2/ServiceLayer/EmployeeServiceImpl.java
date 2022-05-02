package problem2.ServiceLayer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import problem2.Beans.Employee;
import problem2.DataAccessLayer.dao.EmployeeDaoImpl;
import problem2.Exceptions.EmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDaoImpl dao;
	
	public EmployeeServiceImpl() {
		
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		boolean result = dao.insertEmployeeDetails(employee);
		
		if(result) {
			System.out.println("Employee details added successfully");
		} else {
			System.out.println("Employee details not added :(");
		}
		
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {

		ArrayList<Employee> listOfEmployees = (ArrayList<Employee>) dao.getAllEmployeeDetails();
		System.out.println("Details Fetched!");
		return listOfEmployees;
		
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee employee = null;
		try {
			employee = dao.findEmployee(empId);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public String deleteEmployeeById(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		String result = "";
		try {
			result = dao.deleteEmployeeDetailsById(empId);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
