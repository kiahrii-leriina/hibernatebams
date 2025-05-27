package bams.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import bams.model.Accounts;
import bams.util.JpaUtil;

public class AccountDao {
	
	
	public Accounts findAccount(int id) {
		EntityManager em = JpaUtil.getEntityManager();
		return em.find(Accounts.class, id);
	
		
	}
	
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
				accounts.getId(),accounts.getName(),accounts.getBalance());
		et.commit();
		JpaUtil.close();
	}
	
	public void deleteAccount(int id) {

		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Accounts accounts = em.find(Accounts.class, id);
		if(accounts == null) {
			System.out.println("No Account found");
			throw new RuntimeException("No Account Found");
		}
		em.remove(accounts);
		et.commit();
		System.out.println("Account Deleted Successfully");
	}
	
	public void updateAccount(int id) {
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Accounts accounts = em.find(Accounts.class, id);
		Accounts merge = em.merge(accounts);
		et.commit();
		System.out.printf("Account Updated Successfully "
				+ "Account ID: %d | Account Type: %s | Account Balance: %.2f",
				merge.getId(),merge.getName(),merge.getBalance());
	}
	
	
	

}
