package account_item;

import Exceptions.NegativeBalanceException;
import Interfaces.UserAccount;
import account_item.premiumAccount.PremiumAccount;

public class AccountTest {

    public static void main(String[] args) {
        System.out.println("___Interface-Tests___");
        try {
            UserAccount user = new Account(1400, 20, 3);
            System.out.println("Start-Balance: " + user.getBalance());
            user.increaseBalance(10.0);
            System.out.println("Balance nach increaseBalance(10.0): " + user.getBalance());
            boolean gekauft = user.buyItem(new Item("Mais", 15));
            System.out.println("buyItem(Mais) erfolgreich: " + gekauft);
            System.out.println("identifier: " + ((Account) user).identifier());
        } catch (NegativeBalanceException e) {
            System.out.println("Interface-Test -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Interface-Test -> " + e.getMessage());
        }

        System.out.println("\n___Exception-Tests: Account");
        try {
            new Account(-1, 10, 3);
        } catch (NegativeBalanceException e) {
            System.out.println("Account-Konstruktor (negative balance) -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Account-Konstruktor (negative accountId) -> " + e.getMessage());
        }

        try {
            new Account(1, -10, 3);
        } catch (NegativeBalanceException e) {
            System.out.println("Account-Konstruktor (negative balance) -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Account-Konstruktor -> " + e.getMessage());
        }

        try {
            new Account(1, 10, 0);
        } catch (NegativeBalanceException e) {
            System.out.println("Account-Konstruktor -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Account-Konstruktor (maxItems <= 0) -> " + e.getMessage());
        }

        try {
            Account a = new Account(2000, 20, 2);
            a.setAccountId(-5);
        } catch (NegativeBalanceException e) {
            System.out.println("setAccountId -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("setAccountId -> " + e.getMessage());
        }

        try {
            Account a = new Account(2001, 20, 2);
            a.setBalance(-1);
        } catch (NegativeBalanceException e) {
            System.out.println("setBalance -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("setBalance -> " + e.getMessage());
        }

        try {
            Account a = new Account(2002, 20, 2);
            a.setMaxItems(0);
        } catch (NegativeBalanceException e) {
            System.out.println("setMaxItems -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("setMaxItems -> " + e.getMessage());
        }

        try {
            Account a = new Account(2003, 20, 2);
            a.getItem(0);
        } catch (NegativeBalanceException e) {
            System.out.println("getItem -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("getItem -> " + e.getMessage());
        }

        try {
            Account a = new Account(2004, 20, 2);
            a.setItem(0, new Item("Reis", 2));
        } catch (NegativeBalanceException e) {
            System.out.println("setItem -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("setItem -> " + e.getMessage());
        }

        try {
            Account a = new Account(2007, 20, 2);
            a.buyItem(new Item("Reis", 2));
            a.setItem(0, null);
        } catch (NegativeBalanceException e) {
            System.out.println("setItem(null) -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("setItem(null) -> " + e.getMessage());
        }

        try {
            Account a = new Account(2005, 20, 2);
            a.buyItem(null);
        } catch (NegativeBalanceException e) {
            System.out.println("buyItem(null) -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("buyItem(null) -> " + e.getMessage());
        }

        try {
            Account a = new Account(2006, 20, 2);
            a.increaseBalance(-4);
        } catch (NegativeBalanceException e) {
            System.out.println("increaseBalance -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("increaseBalance -> " + e.getMessage());
        }

        System.out.println("\n___Exception-Tests: Item___");
        try {
            new Item("", 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Item-Konstruktor -> " + e.getMessage());
        }

        try {
            new Item("Brot", -1);
        } catch (IllegalArgumentException e) {
            System.out.println("Item-Konstruktor -> " + e.getMessage());
        }

        System.out.println("\n___Exception-Tests: PremiumAccount___");
        try {
            new PremiumAccount(3000, 20, 2, 0, 0.2);
        } catch (NegativeBalanceException e) {
            System.out.println("PremiumAccount-Konstruktor -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("PremiumAccount-Konstruktor -> " + e.getMessage());
        }

        try {
            new PremiumAccount(3001, 20, 2, 5, 1.5);
        } catch (NegativeBalanceException e) {
            System.out.println("PremiumAccount-Konstruktor -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("PremiumAccount-Konstruktor -> " + e.getMessage());
        }

        try {
            PremiumAccount p = new PremiumAccount(3002, 20, 2, 5, 0.2);
            p.setPremiumFee(0);
        } catch (NegativeBalanceException e) {
            System.out.println("setPremiumFee -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("setPremiumFee -> " + e.getMessage());
        }

        try {
            PremiumAccount p = new PremiumAccount(3003, 20, 2, 5, 0.2);
            p.setDiscountRate(-0.1);
        } catch (NegativeBalanceException e) {
            System.out.println("setDiscountRate -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("setDiscountRate -> " + e.getMessage());
        }

        try {
            PremiumAccount p = new PremiumAccount(3004, 20, 2, 5, 0.2);
            p.buyItem(null);
        } catch (NegativeBalanceException e) {
            System.out.println("Premium buyItem(null) -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Premium buyItem(null) -> " + e.getMessage());
        }

        try {
            PremiumAccount p = new PremiumAccount(3005, 3, 2, 5, 0.2);
            p.chargeMonthlyFee();
        } catch (NegativeBalanceException e) {
            System.out.println("chargeMonthlyFee -> " + e.getMessage());
        }

        System.out.println("\n___equals / hashCode Tests___");
        try {
            Item item1 = new Item("Apfel", 5);
            Item item2 = new Item("Apfel", 5);

            Account account1 = new Account(5000, 30, 3);
            account1.buyItem(new Item("Apfel", 5));
            Account account2 = new Account(5000, 30, 3);
            account2.buyItem(new Item("Apfel", 5));

            PremiumAccount premium1 = new PremiumAccount(6000, 40, 3, 5, 0.2);
            premium1.buyItem(new Item("Buch", 10));
            PremiumAccount premium2 = new PremiumAccount(6000, 40, 3, 5, 0.2);
            premium2.buyItem(new Item("Buch", 10));

            System.out.println("item1.equals(item2): " + item1.equals(item2));
            System.out.println("item1.hashCode(): " + item1.hashCode());
            System.out.println("item2.hashCode(): " + item2.hashCode());

            System.out.println("account1.equals(account2): " + account1.equals(account2));
            System.out.println("account1.hashCode(): " + account1.hashCode());
            System.out.println("account2.hashCode(): " + account2.hashCode());

            System.out.println("premium1.equals(premium2): " + premium1.equals(premium2));
            System.out.println("premium1.hashCode(): " + premium1.hashCode());
            System.out.println("premium2.hashCode(): " + premium2.hashCode());
        } catch (NegativeBalanceException e) {
            System.out.println("equals/hashCode Tests -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("equals/hashCode Tests -> " + e.getMessage());
        // Ja hat es
        }
    }
}
