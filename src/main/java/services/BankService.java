package services;

import entities.Account;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BankService implements IBankService {
    private static Long counter = Long.valueOf(0);
    private Map<Long, Account> list;

    public BankService() {
        this.list = new HashMap();
    }

    @Override
    public Account addAccount(double initialBalance) {
        Account account = new Account(++BankService.counter, initialBalance, new Date());
        this.list.put(account.getId(), account);
        return account;
    }

    @Override
    public Account getAccount(Long accountId) {
        return this.list.get(accountId);
    }

    @Override
    public Map<Long, Account> getAllAccounts() {
        return list;
    }

    @Override
    public void credit(Long accountId, double amount) {
        Account account = this.getAccount(accountId);
        account.setBalance(account.getBalance() + amount);
    }

    @Override
    public void debit(Long accountId, double amount) {
        Account account = this.getAccount(accountId);
        account.setBalance(account.getBalance() - amount);
    }
}
