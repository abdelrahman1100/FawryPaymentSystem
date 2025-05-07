package com.example.phase2.services;

import com.example.phase2.models.CreditCard;
import com.example.phase2.repositories.CreditCardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {
    CreditCardRepository creditCardRepository;
    @Autowired
    public CreditCardService(CreditCardRepository creditCardRepository){
        this.creditCardRepository=creditCardRepository;
    }

    @Transactional
    public CreditCard save(CreditCard creditCard){
        return creditCardRepository.save(creditCard);
    }
}
