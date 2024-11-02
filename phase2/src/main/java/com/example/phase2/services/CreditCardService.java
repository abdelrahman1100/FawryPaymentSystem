package com.example.phase2.services;

import com.example.phase2.models.user.CreditCard;
import com.example.phase2.repositories.CreditCardRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {
    CreditCardRepository creditCardRepository;
    public CreditCardService(CreditCardRepository creditCardRepository){
        this.creditCardRepository=creditCardRepository;
    }
    @Transactional
    void save(CreditCard creditCard){
        creditCardRepository.save(creditCard);
    }
    @Transactional
    void AddAmount(String cardNumber,double amount){
        CreditCard creditCard=creditCardRepository.findCreditCardByCardNumber(cardNumber);
        creditCard.setAmount(creditCard.getAmount()-amount);
        creditCardRepository.save(creditCard);
    }
    @Transactional
    void withdrawAmount(String cardNumber,double amount){
        CreditCard creditCard=creditCardRepository.findCreditCardByCardNumber(cardNumber);
        creditCard.setAmount(creditCard.getAmount()-amount);
        creditCardRepository.save(creditCard);
    }
    @Transactional
    void addAmount(String cardNumber,double amount){
        CreditCard creditCard=creditCardRepository.findCreditCardByCardNumber(cardNumber);
        creditCard.setAmount(creditCard.getAmount()+amount);
        creditCardRepository.save(creditCard);
    }
}
