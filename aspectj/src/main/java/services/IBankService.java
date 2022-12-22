package services;

import entities.Account;

import java.util.Map;

public interface IBankService {
    Account addAccount(double initialBalance);
    Account getAccount(Long accountId);
    Map<Long, Account> getAllAccounts();
    void credit(Long accountId, double amount);
    void debit(Long accountId, double amount);
}
