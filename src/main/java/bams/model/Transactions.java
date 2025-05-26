package bams.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int fromaccount;
	private int toaccount;
	private double amount;
	private Timestamp timestamp;
	@ManyToOne
	private Accounts account;
	
	
	@Override
	public String toString() {
		return "Transactions [id=" + id + ", fromaccount=" + fromaccount + ", toaccount=" + toaccount + ", amount="
				+ amount + ", timestamp=" + timestamp + ", account=" + account + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFromaccount() {
		return fromaccount;
	}
	public void setFromaccount(int fromaccount) {
		this.fromaccount = fromaccount;
	}
	public int getToaccount() {
		return toaccount;
	}
	public void setToaccount(int toaccount) {
		this.toaccount = toaccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public Accounts getAccount() {
		return account;
	}
	public void setAccount(Accounts account) {
		this.account = account;
	}
	public Transactions(int id, int fromaccount, int toaccount, double amount, Timestamp timestamp, Accounts account) {
		super();
		this.id = id;
		this.fromaccount = fromaccount;
		this.toaccount = toaccount;
		this.amount = amount;
		this.timestamp = timestamp;
		this.account = account;
	}
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
