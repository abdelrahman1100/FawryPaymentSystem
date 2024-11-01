package com.example.phase2.repositories;

import com.example.phase2.models.user.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,String> {
    CreditCard findCreditCardByCardNumber(String cardNumber);
}
