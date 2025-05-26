package bams.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	private static final ThreadLocal<EntityManager> threadlocal= new ThreadLocal<>();
	
	public static EntityManager getEntityManager() {
		EntityManager em = threadlocal.get();
		if(em == null || !em.isOpen()) {
			em = emf.createEntityManager();
			threadlocal.set(em);
		}
		return em;
	}
	
	

	public static void close() {
		EntityManager em = threadlocal.get();
		if(em != null && em.isOpen()) {
			em.close();
			threadlocal.remove();
		}
	}
	

}
