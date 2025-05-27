package bams.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    @Column(name = "timestamp", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp timestamp;


    @ManyToOne
    @JoinColumn(name = "from_account_id")
    private Accounts fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account_id")
    private Accounts toAccount;

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", amount=" + amount + ", timestamp=" + timestamp + ", fromAccount="
				+ fromAccount + ", toAccount=" + toAccount + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Accounts getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Accounts fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Accounts getToAccount() {
		return toAccount;
	}

	public void setToAccount(Accounts toAccount) {
		this.toAccount = toAccount;
	}

	public Transactions(int id, double amount, Timestamp timestamp, Accounts fromAccount, Accounts toAccount) {
		super();
		this.id = id;
		this.amount = amount;
		this.timestamp = timestamp;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
	}

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
	
	
}
