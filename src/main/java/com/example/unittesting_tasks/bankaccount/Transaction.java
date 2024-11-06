package com.example.unittesting_tasks.bankaccount;

public class Transaction {
    private final double amount;

    public Transaction(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
