package sunspot.idbi.entity;

import javax.persistence.*;

@Entity
@Table(name = "currentBalance")
public class CurrentBalance {

	// mobile no is userid

	@Id
	@Column(name = "userId", unique = true, nullable = false)
	private long userId;
	
	@Column(name = "BalanceAmt",nullable = false)
	private long balance;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
}