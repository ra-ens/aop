package aspects;

import entities.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import services.BankService;
import services.IBankService;

@Aspect
public class PatchAspect {
    @Around("execution(* services.BankService.debit(..))&&args(accountId, amount)")
    public void patchDebit(Long accountId, double amount, JoinPoint joinPoint, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        IBankService bankService = (BankService) joinPoint.getTarget();
        Account account = bankService.getAccount(accountId);

        if(account != null && account.getBalance() > amount) {
            Object o = proceedingJoinPoint.proceed();
        }
        else
            throw new RuntimeException("Insufficient balance");
    }

    @Around("execution(* services.BankService.credit(..))&&args(amount)")
    public void patchCredit(double amount, JoinPoint joinPoint, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if(amount > 0) {
            Object o = proceedingJoinPoint.proceed();
        }
        else
            throw new RuntimeException("Credit account should be greater than 0");
    }

    @Around("execution(* services.BankService.getAccount())&&args(accountId)")
    public void patchGetAccount(Long accountId, JoinPoint joinPoint, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        IBankService bankService = (BankService) joinPoint.getTarget();
        Account account = bankService.getAccount(accountId);

        if(account != null) {
            Object o = proceedingJoinPoint.proceed();
        }
        else
            throw new RuntimeException(String.format("Account %s not found", accountId.toString()));
    }
}
