package bams;

import java.util.Scanner;

import bams.dao.UserDao;
import bams.model.Users;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to BAMS");
		while(true) {
			System.out.println("----------------MENU---------------");
			System.out.println("1. save user");
			System.out.println("2. update user");
			System.out.println("3. exit");
			
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
				
				UserDao userdao = new UserDao();
				Users user = new Users();
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setPhone(phone);
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
				System.exit(0);
			}

			default:
				break;
			}
			
		}
	
		
	}

}
