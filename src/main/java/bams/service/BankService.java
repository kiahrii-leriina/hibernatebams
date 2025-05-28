package bams.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import bams.dao.AccountDao;
import bams.dao.TransactionDao;
import bams.model.Accounts;
import bams.model.Transactions;
import bams.util.JpaUtil;

public class BankService {
	
	public boolean transfer(int fromid, int toid, double amount) {

	    TransactionDao transactiondao = new TransactionDao();
	    AccountDao accountdao = new AccountDao();
	    EntityManager em = JpaUtil.getEntityManager();
	    EntityTransaction et = em.getTransaction();

	    try {
	        et.begin();
	        Accounts fromaccount = accountdao.findAccount(fromid, em);
	        Accounts toaccount = accountdao.findAccount(toid, em);
	        
	        if (fromaccount != null && toaccount != null && fromaccount.getId() != 0 && toaccount.getId() != 0
	                && fromaccount.getBalance() >= amount) {
	            fromaccount.setBalance(fromaccount.getBalance() - amount);
	            toaccount.setBalance(toaccount.getBalance() + amount);

	            Transactions transaction = new Transactions();
	            transaction.setFromAccount(fromaccount);
	            transaction.setToAccount(toaccount);
	            transaction.setAmount(amount);

	            transactiondao.saveTransaction(em, transaction); // use same EM

	            et.commit();
	            return true;
	        }
	        return false;
	        } catch (Exception e) {
	        System.out.println("Transfer failed due to: " + e.getMessage());
	        e.printStackTrace(); // 🔍 Show full stack trace
	        if (et.isActive()) {
	            et.rollback();
	        }
	        return false;
	    } finally {
	        JpaUtil.close();
	    }
	}

	
	public boolean withdraw(int id, double amount) {
		if(id == 0) {
			System.out.println("Invalid account id");
			return false;
		}
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			
			AccountDao accountdao = new AccountDao();
			Accounts account = accountdao.findAccount(id, em);
			
			if(account.getBalance() > amount) {
				account.setBalance(account.getBalance()-amount);
				et.commit();
				return true;
			}
			return false;
			
		}catch(Exception e) {
			et.rollback();
			return false;
		}finally {
			JpaUtil.close();
		}
	}
	
	public boolean deposit(int id, double amount) {
		
		
		if(id == 0) {
			System.out.println("Invalid account id");
			return false;
		}
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			
			AccountDao accountdao = new AccountDao();
			Accounts account = accountdao.findAccount(id, em);
			
			account.setBalance(account.getBalance()+amount);
			em.merge(account);
			
			et.commit();
			return true;

		}catch(Exception e) {
			et.rollback();
			return false;
		}finally {
			JpaUtil.close();
		}
	}

}

