package bams;

import java.util.Scanner;

import bams.dao.AccountDao;
import bams.dao.UserDao;
import bams.model.Accounts;
import bams.model.Users;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to BAMS");
		while(true) {
			System.out.println("----------------MENU--------------- \n");
			System.out.println("1. save user");
			System.out.println("2. update user");
			System.out.println("3. delete user");
			System.out.println("4. view all users");
			System.out.println("5. Check account detials");
			System.out.println("6. exit");
			
			switch (sc.nextInt()) {
			case 1:{
				System.out.println("Enter user name");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter email ");
				String email = sc.next();
				System.out.println("Enter Password");
				String password = sc.next();
				System.out.println("Enter Phone");
				long phone = sc.nextLong();
				
				System.out.println("Enter account type: (saving/current)");
				String acctype = sc.next();
				System.out.println("Make initial deposit (any amout not less then RS.100)");
				double amount = sc.nextDouble();
				
				
				Accounts account = new Accounts();
				account.setName(acctype);
				account.setBalance(amount);
				
				
				UserDao userdao = new UserDao();
				Users user = new Users();
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setPhone(phone);
				user.setAccount(account);
				
				userdao.saveUser(user);
				
				break;
				}
				
			case 2:{
				System.out.println("Enter user id");
				int id  = sc.nextInt();
				System.out.println("Enter user name");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter email ");
				String email = sc.next();
				System.out.println("Enter Password");
				String password = sc.next();
				System.out.println("Enter Phone");
				long phone = sc.nextLong();
				UserDao userdao = new UserDao();
				userdao.updateUser(id, name, email, password, phone);
				break;
				
			}
			
			case 3:{
				System.out.println("Enter user id");
				int id = sc.nextInt();
				UserDao userdao = new UserDao();
				userdao.deleteUser(id);
			}
			
			case 4:{
				UserDao userdao = new UserDao();
				userdao.allUsers();
				break;
			}
			
			case 5:{
				System.out.println("Enter Account id");
				int id = sc.nextInt();
				AccountDao accountdao = new AccountDao();
				accountdao.accountDetail(id);
				break;
			}
			
			case 6:{
				System.exit(0);
			}

			default:
				break;
			}
			
		}
	
		
	}

}
