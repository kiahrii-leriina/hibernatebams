package bams.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(precision = 10, scale = 2)
	private double balance;
	@OneToOne(mappedBy = "account")
	private Users user;
	
	
	@Override
	public String toString() {
		return "Accounts [id=" + id + ", name=" + name + ", balance=" + balance + ", user=" + user + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Accounts(int id, String name, double balance, Users user) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.user = user;
	}
	public Accounts() {
		super();
	}
	
	
	
}
