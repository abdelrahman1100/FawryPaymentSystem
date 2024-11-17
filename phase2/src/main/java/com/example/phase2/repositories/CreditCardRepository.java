package com.example.phase2.repositories;

import com.example.phase2.models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
    CreditCard findCreditCardByCardNumber(String cardNumber);
}
