import entities.Account;
import services.BankService;
import services.IBankService;

import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        new Application().start();
    }

    public void start() {
        System.out.println("Application running...");
        IBankService bankService = new BankService();
        Scanner in = new Scanner(System.in);
        Account account;
        Long id;
        int opt = 0;

        do {
            try {
                System.out.println("============ MENU ============");
                System.out.println("1: Add new account\n2: Get account\n3: List all accounts\n4: Credit account\n5: Debit account\n0: Quit");
                System.out.println("==============================\n");
                System.out.print("Enter an option: ");
                opt = in.nextInt();

                switch (opt) {
                    case 1:
                        System.out.print("\tInitial balance: ");
                        Account savedAccount = bankService.addAccount(in.nextDouble());
                        System.out.println(savedAccount.toString());
                        break;
                    case 2:
                        System.out.print("\tAccount id: ");
                        account = bankService.getAccount(in.nextLong());
                        System.out.println(account.toString());
                        break;
                    case 3:
                        Map accountList = bankService.getAllAccounts();
                        accountList.forEach((key, acc) -> {
                            System.out.println("\t" + acc.toString());
                        });
                        break;
                    case 4:
                        System.out.print("\tAccount id: ");
                        id = in.nextLong();
                        System.out.print("\tAmount: ");
                        bankService.credit(id, in.nextDouble());
                        break;
                    case 5:
                        System.out.print("\tAccount id: ");
                        id = in.nextLong();
                        System.out.print("\tAmount: ");
                        bankService.debit(id, in.nextDouble());
                        break;
                    case 0:
                        System.out.println("Quiting the application...");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while(opt != 0);
    }
}
