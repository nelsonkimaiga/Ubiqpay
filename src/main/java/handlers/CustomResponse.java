package handlers;

import java.math.BigDecimal;

public class CustomResponse {

    private String status;
    private String message;
    private String accountId;
    private BigDecimal amount;
    private String externalTransactionId;
    private String currency;
    private int Id;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getExternalTransactionId() {
		return externalTransactionId;
	}
	public void setExternalTransactionId(String externalTransactionId) {
		this.externalTransactionId = externalTransactionId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

  
}
