package ma.hh.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "BankAccounts")

public class BankAccount {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "account_number", length = 16)
	private String accountNumber;
	@Column(name = "cvv", length = 3)
	private int cvv;
	@Column(name = "balance")
	private long balance;

	
	public BankAccount( String accountNumber, int cvv, long balance ) {
		super();
		this.accountNumber = accountNumber;
		this.cvv = cvv;
		this.balance = balance;
	}
	
	
	
}
