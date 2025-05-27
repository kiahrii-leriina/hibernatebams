package bams.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import bams.model.Transactions;
import bams.util.JpaUtil;

public class TransactionDao {

	public void saveTransaction(Transactions transaction) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(transaction);
		et.commit();
		JpaUtil.close();
	}

}
