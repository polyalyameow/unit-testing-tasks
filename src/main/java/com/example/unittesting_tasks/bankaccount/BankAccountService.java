package com.example.unittesting_tasks.bankaccount;

public class BankAccountService {

    private double balance = 0.0;
    private final TransactionRepository transactionRepository;

    public BankAccountService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionRepository.save(new Transaction(amount));
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
        transactionRepository.save(new Transaction(-amount));
    }

    public double getBalance() {
        return balance;
    }

}
