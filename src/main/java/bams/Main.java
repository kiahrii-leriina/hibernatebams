package bams;

import java.util.Scanner;

import bams.dao.AccountDao;
import bams.dao.TransactionDao;
import bams.dao.UserDao;
import bams.model.Accounts;
import bams.model.Users;
import bams.service.BankService;

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
			System.out.println("6. Transfer money");
			System.out.println("7. Deposit money");
			System.out.println("8. Withdraw money");
			System.out.println("9. See All transaction history");
			System.out.println("10. Credited History");
			System.out.println("11. Debited History");
			System.out.println("12. exit");
			
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
				break;
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
				
				System.out.println("Enter Account id to transfer from");
				int fromacountid = sc.nextInt();
				System.out.println("Enter account to transfer to");
				int toaccountid = sc.nextInt();
				System.out.println("Enter amount");
				double amount = sc.nextDouble();
				BankService service = new BankService();
				if(service.transfer(fromacountid, toaccountid, amount)) {
					System.out.println("Transaction successfull");
				}
				else {
					
					System.out.println("Transaction fail");
				}
				break;
				
			}
			
			case 7:{
				
				System.out.println("Deposit");
				System.out.println("Enter Account id");
				int accountid = sc.nextInt();
				System.out.println("Enter deposit amount");
				double amount = sc.nextDouble();
				BankService service = new BankService();
				if(service.deposit(accountid, amount)){
					System.out.println("Deposit successfull");
				}
				System.out.println("Deposit fail");
				break;
				
			}
			
			case 8:{
				
				System.out.println("Withraw");
				System.out.println("Enter Account id");
				int accountid = sc.nextInt();
				System.out.println("Enter withdraw amount");
				double amount = sc.nextDouble();
				BankService service = new BankService();
				if(service.withdraw(accountid, amount)){
					System.out.println("Withdraw successfull");
				}
				System.out.println("Withdraw fail");
				break;
				
			}
			
			case 9:{
				
				System.out.println("All transaction history");
				System.out.println("Enter Account id");
				int accountid = sc.nextInt();
				TransactionDao transactiondao = new TransactionDao();
				transactiondao.transactionHistory(accountid);
				break;
			}
			
			case 10:{
				
				System.out.println("Creadited history");
				System.out.println("Enter Account id");
				int accountid = sc.nextInt();
				TransactionDao transactiondao = new TransactionDao();
				transactiondao.received(accountid);
				break;
				
			}
			
			case 11:{
				System.out.println("Debited History");
				System.out.println("Enter account id");
				int accountid = sc.nextInt();
				TransactionDao transactiondao = new TransactionDao();
				transactiondao.send(accountid);
				break;
				
			}
		
			case 12:{
				System.exit(0);
			}

			default:
				break;
			}
			
		}
	
		
	}

}
