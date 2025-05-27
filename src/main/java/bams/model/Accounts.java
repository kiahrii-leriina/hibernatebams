package bams.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Accounts {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double balance;
    
    @OneToOne(mappedBy = "account")
    private Users user;

    @OneToMany(mappedBy = "fromAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transactions> sentTransactions;

    @OneToMany(mappedBy = "toAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transactions> receivedTransactions;

	@Override
	public String toString() {
		return "Accounts [id=" + id + ", name=" + name + ", balance=" + balance + ", sentTransactions="
				+ sentTransactions + ", receivedTransactions=" + receivedTransactions + "]";
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

	public List<Transactions> getSentTransactions() {
		return sentTransactions;
	}

	public void setSentTransactions(List<Transactions> sentTransactions) {
		this.sentTransactions = sentTransactions;
	}

	public List<Transactions> getReceivedTransactions() {
		return receivedTransactions;
	}

	public void setReceivedTransactions(List<Transactions> receivedTransactions) {
		this.receivedTransactions = receivedTransactions;
	}

	public Accounts(int id, String name, double balance, List<Transactions> sentTransactions,
			List<Transactions> receivedTransactions) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.sentTransactions = sentTransactions;
		this.receivedTransactions = receivedTransactions;
	}

	public Accounts() {
		super();
	}
	
	
	
	
	
}
