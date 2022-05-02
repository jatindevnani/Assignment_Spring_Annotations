package problem2.DataAccessLayer.utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("employeeUnit");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
