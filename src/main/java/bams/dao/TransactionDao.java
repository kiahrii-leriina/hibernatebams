package bams.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import bams.model.Transactions;
import bams.util.JpaUtil;

public class TransactionDao {

	public void saveTransaction(EntityManager em, Transactions transaction) {
	    em.persist(transaction);
	}


	public void transactionHistory(int accountId) {
	    EntityManager em = JpaUtil.getEntityManager();
	    String jpql = "SELECT t FROM Transactions t WHERE t.fromAccount.id = :id OR t.toAccount.id = :id ORDER BY t.timestamp DESC";
	    TypedQuery<Transactions> query = em.createQuery(jpql, Transactions.class);
	    query.setParameter("id", accountId);
	    
	    List<Transactions> resultList = query.getResultList();
	    if (resultList.isEmpty()) {
	        System.out.println("No transaction found for this account");
	    } else {
	        for (Transactions t : resultList) {
	            System.out.printf("Txn_ID: | FromAccount: %d | ToAccount: %d | Amount: %.2f | Timestamp: %s \n",
	                    t.getFromAccount().getId(), t.getToAccount().getId(), t.getAmount(), t.getTimestamp());
	        }
	    }
	    em.close();
	}

	
	
	public void received(int accountId) {
	    EntityManager em = JpaUtil.getEntityManager();
	    String jpql = "SELECT t FROM Transactions t WHERE t.toAccount.id = :id ORDER BY t.timestamp DESC";
	    TypedQuery<Transactions> query = em.createQuery(jpql, Transactions.class);
	    query.setParameter("id", accountId);
	    
	    List<Transactions> resultList = query.getResultList();
	    if (resultList.isEmpty()) {
	        System.out.println("No incoming transactions.");
	    } else {
	        for (Transactions t : resultList) {
	            System.out.printf("From: %d | Amount: %.2f | Timestamp: %s\n",
	                    t.getFromAccount().getId(), t.getAmount(), t.getTimestamp());
	        }
	    }
	    em.close();
	}

	
	
	public void send(int accountid) {
	
		 EntityManager em = JpaUtil.getEntityManager();
		    String jpql = "SELECT t FROM Transactions t WHERE t.fromAccount.id = :id ORDER BY t.timestamp DESC";
		    TypedQuery<Transactions> query = em.createQuery(jpql, Transactions.class);
		    query.setParameter("id", accountid);
		    
		    List<Transactions> resultList = query.getResultList();
		    if (resultList.isEmpty()) {
		        System.out.println("No outgoing transactions.");
		    } else {
		        for (Transactions t : resultList) {
		            System.out.printf("To: %d | Amount: %.2f | Timestamp: %s\n",
		                    t.getToAccount() .getId(), t.getAmount(), t.getTimestamp());
		        }
		    }
		    em.close();
	}

}
