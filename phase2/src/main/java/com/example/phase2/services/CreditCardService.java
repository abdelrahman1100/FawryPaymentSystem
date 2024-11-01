package com.example.phase2.services;

import com.example.phase2.models.user.CreditCard;
import com.example.phase2.repositories.CreditCardRepository;

public class CreditCardService {
    private CreditCardRepository creditCardRepository;
    public CreditCardService(CreditCardRepository creditCardRepository){
        this.creditCardRepository=creditCardRepository;
    }
    void save(CreditCard creditCard){
        creditCardRepository.save(creditCard);
    }
    void AddAmount(String cardNumber,double amount){
        CreditCard creditCard=creditCardRepository.findCreditCardByCardNumber(cardNumber);
        creditCard.setAmount(creditCard.getAmount()-amount);
        creditCardRepository.save(creditCard);
    }
    void withdrawAmount(String cardNumber,double amount){
        CreditCard creditCard=creditCardRepository.findCreditCardByCardNumber(cardNumber);
        creditCard.setAmount(creditCard.getAmount()-amount);
        creditCardRepository.save(creditCard);
    }
    void addAmount(String cardNumber,double amount){
        CreditCard creditCard=creditCardRepository.findCreditCardByCardNumber(cardNumber);
        creditCard.setAmount(creditCard.getAmount()+amount);
        creditCardRepository.save(creditCard);
    }
}
