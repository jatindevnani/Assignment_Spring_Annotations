package problem2.DataAccessLayer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import problem2.Beans.Employee;
import problem2.DataAccessLayer.utilities.EMUtil;
import problem2.Exceptions.EmployeeException;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public boolean insertEmployeeDetails(Employee emp) {
		EntityManager em = EMUtil.getEntityManager();
		boolean bool = false;
		em.getTransaction().begin();
		em.persist(emp);
		bool = true;
		em.getTransaction().commit();
		return bool;
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		// TODO Auto-generated method stub\
		EntityManager em = EMUtil.getEntityManager();
		String jpql = "from Employee";
		TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public Employee findEmployee(int empId) throws EmployeeException{
		EntityManager em = EMUtil.getEntityManager();
		String jpql = "from Employee WHERE ID=" + empId;
		Employee employee;
		
		try {
			TypedQuery<Employee> result = em.createQuery(jpql, Employee.class);
			employee = result.getSingleResult();
		} catch (Exception e) {
			throw new EmployeeException("Employee not found");
		}
		
		return employee;
	}

	@Override
	public String deleteEmployeeDetailsById(int empId) throws EmployeeException {
		String result = "Employee not deleted";
		EntityManager em = EMUtil.getEntityManager();
		String jpql = "delete from Employee where ID=:id";
		Query query = em.createQuery(jpql);
		query.setParameter("id", empId);
		
		try {
			em.getTransaction().begin();
			query.executeUpdate();
			result = "Employee deleted";
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new EmployeeException("Employee doesn't exist");
		}
		return result;
	}

}
