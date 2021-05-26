package com.test.ubiq.controller;

import com.test.ubiq.model.UbiqPay;
import com.test.ubiq.repository.UbiqPayRepository;

import handlers.CustomResponse;
import handlers.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UbiqPayController {

    @Autowired
    UbiqPayRepository ubiqPayRepository;

    // Making Payments from A:
    @PostMapping(path = { "/payments" }, consumes = { "application/json" }, produces = {"application/json"})
    public CustomResponse payment (@RequestBody UbiqPay ubiq) {
    	
    	// RESPONSE
        CustomResponse response = new CustomResponse();
        response.setAccountId(ubiq.getAccountID());
        response.setAmount(ubiq.getAmount());
        response.setExternalTransactionId(ubiq.getExternalTransactionId());
        response.setCurrency(ubiq.getCurrency());
        response.setId(ubiq.getId());

        try {
        	// store the data:
        	ubiqPayRepository.save(ubiq);
            
            // set status flag:
            response.setStatus("INITIATED");
            response.setMessage("Transaction successfully initiated");

        } catch (Exception no) {
            System.out.println("Error : " +no.getMessage());

            response.setStatus("Failed");
            response.setMessage("Transaction initiation failed");

        }
        
        return response;

    }

    // Payment Confirmation:
    @PostMapping(path = { "/transactions" }, consumes = { "application/json" }, produces = {"application/json"})
    public CustomResponse transactions (@RequestBody Payment payment) {

        CustomResponse response = new CustomResponse();

        UbiqPay ubiq = ubiqPayRepository.findByReference(payment.getReference());

        response.setAccountId(ubiq.getAccountID());
        response.setAmount(ubiq.getAmount());
        response.setExternalTransactionId(ubiq.getExternalTransactionId());
        response.setCurrency(ubiq.getCurrency());
        response.setId(ubiq.getId());

        try {
        	ubiqPayRepository.updateTransactionStatus("CONFIRMED",payment.getReference());
            
            // update status flag
            response.setStatus("CONFIRMED");
            response.setMessage("Payment confirmed");


        } catch (Exception no) {
            System.out.println("Error : " +no.getMessage());

            response.setStatus("Failed");
            response.setMessage("Transaction not confirmed");
        }

        return response;


    }

}
