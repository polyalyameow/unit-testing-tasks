package com.example.unittesting_tasks;

import com.example.unittesting_tasks.bankaccount.BankAccountService;
import com.example.unittesting_tasks.bankaccount.Transaction;
import com.example.unittesting_tasks.bankaccount.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountServiceTest {

    @InjectMocks
    BankAccountService bankAccountService;

    @Mock
    TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeposit(){
        bankAccountService.deposit(100);
        assertEquals(100, bankAccountService.getBalance());
        verify(transactionRepository, times(1)).save(any(Transaction.class));
    }

    @Test
    void testWithdraw(){
        bankAccountService.deposit(200);
        bankAccountService.withdraw(100);
        assertEquals(100, bankAccountService.getBalance());
        verify(transactionRepository, times(2)).save(any(Transaction.class));
    }

    @Test
    void testWithdrawWithInufficientBalance() {
        assertThrows(IllegalArgumentException.class, () -> bankAccountService.withdraw(100));
        verify(transactionRepository, never()).save(any(Transaction.class));
    }
}
