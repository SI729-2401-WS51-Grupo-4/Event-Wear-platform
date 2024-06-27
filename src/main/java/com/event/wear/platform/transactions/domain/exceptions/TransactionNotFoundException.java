package com.event.wear.platform.transactions.domain.exceptions;

public class TransactionNotFoundException extends RuntimeException{
    public TransactionNotFoundException(Long aLong){
        super("Transaction with id " + aLong + " not found");
    }
}