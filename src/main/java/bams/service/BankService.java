package bams.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import bams.dao.AccountDao;
import bams.dao.TransactionDao;
import bams.model.Accounts;
import bams.model.Transactions;
import bams.util.JpaUtil;

public class BankService {
	
	public boolean Transfer(int fromid, int toid, double amount) {

		TransactionDao transactiondao = new TransactionDao();
		AccountDao accountdao = new AccountDao();
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		try {

			et.begin();
			Accounts fromaccount = accountdao.findAccount(fromid);
			Accounts toaccount = accountdao.findAccount(toid);
			if (fromaccount != null && toaccount != null && fromaccount.getId() != 0 && toaccount.getId() != 0
					&& fromaccount.getBalance() >= amount) {
				fromaccount.setBalance(fromaccount.getBalance()-amount);
				toaccount.setBalance(toaccount.getBalance()+amount);
				
				Transactions transaction = new Transactions();
				transaction.setFromAccount(fromaccount);
				transaction.setToAccount(toaccount);
				transaction.setAmount(amount);
				
				transactiondao.saveTransaction(transaction);
				
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println("Transfer fail");
			et.rollback();
			return false;
		} finally {
			JpaUtil.close();
		}

	}

}

