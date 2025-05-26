package bams.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import bams.model.Accounts;
import bams.util.JpaUtil;

public class AccountDao {
	
	
	public void accountDetail(int id) {
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Accounts accounts = em.find(Accounts.class, id);
		if(accounts == null) {
			System.out.println("No Account found");
			throw new RuntimeException("No Account found");
		}
		System.out.printf("Account id: %d | Name: %s | Balance: %.2f | Users_id: %d \n",
				accounts.getId(),accounts.getName(),accounts.getBalance(),accounts.getUser().getId());
		et.commit();
		JpaUtil.close();
	}
	
	
	
	

}
