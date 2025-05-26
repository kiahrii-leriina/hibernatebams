package bams.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import bams.model.Accounts;
import bams.model.Users;
import bams.util.JpaUtil;

public class UserDao {

	public void saveUser(Users user) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		user = em.merge(user);
		
		System.out.printf("User saved successfuly "
				+ "ID: %d | Name: %s | Email: %s | Password: %s | Phone: %d | Account_id: %d \n",
				user.getId(),user.getName(),user.getEmail(),user.getPassword(),user.getPhone(),user.getAccount().getId());
		
		et.commit();
		JpaUtil.close();
		
	}
	
	public void updateUser(int id, String name, String email,String password, long phone ) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Users users = em.find(Users.class, id);
		if(users == null) {
			throw new RuntimeException("No user found");
		}
		Users user = new Users();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		et.begin();
		user = em.merge(user);
		et.commit();
		
		System.out.printf("User info updated successfully: "
				+ "ID: %d | Name: %s | Email: %s | Password: %s | Phone: %d | Account_id: %d",
				user.getId(),user.getName(),user.getEmail(),user.getPassword(),user.getPhone(),user.getAccount().getId());
		
		JpaUtil.close();
		
	}
	
	
	public void allUsers() {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query q = em.createQuery("from Users");
		List<Users> userlist = q.getResultList();
		if(userlist.isEmpty()) {
			throw new RuntimeException("No user found");
		}
		for(Users user : userlist) {
			System.out.printf("ID: %d | Name: %s | Email: %s | Password: %s | Phone: %d | Account_id: %d \n",
					user.getId(),user.getName(),user.getEmail(),user.getPassword(),user.getPhone(),user.getAccount().getId());
		}
		
		et.commit();
		JpaUtil.close();
	}

	public void deleteUser(int id) {

		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Users userid = em.find(Users.class, id);
		if(userid == null) {
			System.out.println(" User id not found");
			throw new RuntimeException("No user found");
		}
		em.remove(userid);
		et.commit();
		System.out.println("user deleted");
		JpaUtil.close();
		
	}
	
	
}




