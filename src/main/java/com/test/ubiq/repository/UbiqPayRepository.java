package com.test.ubiq.repository;

import com.test.ubiq.model.UbiqPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UbiqPayRepository extends JpaRepository<UbiqPay, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE UbiqPay u SET u.transactionStatus = ?1 WHERE u.id = ?2")
    void updateTransactionStatus (String transactionStatus,  String transactionID);

    @Query(value = "SELECT u FROM UbiqPay u where u.externalTransactionId = ?1")
    UbiqPay findByReference (String reference);

}
