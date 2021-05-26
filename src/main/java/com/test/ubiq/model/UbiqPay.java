package com.test.ubiq.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ubiq_pay")
public class UbiqPay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("ID")
    private int id;

    @Column(name = "accountId", nullable = false)
    @JsonProperty("accountId")
    private String accountID;

    @Column(name = "amount", nullable = false)
    @JsonProperty("amount")
    private BigDecimal amount;

    @Column(name = "currency", nullable = false)
    @JsonProperty("currency")
    private String currency;

    @Column(name = "externalTransactionId", nullable = false)
    @JsonProperty("externalTransactionId")
    private String externalTransactionId;

    @JsonProperty("status")
    private String transactionStatus = "INITIATED";
    
    @Column
    private String confirmPaymentUrl;

    public UbiqPay() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExternalTransactionId() {
        return externalTransactionId;
    }

    public void setExternalTransactionId(String externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getConfirmPaymentUrl() {
        return confirmPaymentUrl;
    }

    public void setConfirmPaymentUrl(String confirmPaymentUrl) {
        this.confirmPaymentUrl = confirmPaymentUrl;
    }
}
