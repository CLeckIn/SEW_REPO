package account_item;

import Exceptions.NegativeBalanceException;
import Interfaces.Identifizierbar;
import Interfaces.UserAccount;

import java.util.Random;

public class Account implements Identifizierbar, UserAccount {
    private int accountId;
    private int balance;
    private int maxItems;
    private Item[] inventory;

    public Account(int accountId, int balance, int maxItems) throws IllegalArgumentException, NegativeBalanceException {
        this.accountId = 2222;
        this.balance = 0;
        this.setAccountId(accountId);
        this.setBalance(balance);
        if (maxItems <= 0) {
            throw new IllegalArgumentException("Die maximale Anzahl an Items muss positiv sein.");
        }
        this.maxItems = maxItems;
        this.inventory = new Item[0];
    }

    public Account() throws IllegalArgumentException, NegativeBalanceException {
        this(1000 + new Random().nextInt(9000), 0, 10);
    }

    public void setAccountId(int accountId) throws IllegalArgumentException {
        if (accountId < 0) {
            throw new IllegalArgumentException("Die Account-ID darf nicht negativ sein.");
        }
        this.accountId = accountId;
    }

    public int getBalance() {
        return this.balance;
    }

    @Override
    public void increaseBalance(double uploadCredit) {
        int credit = (int) uploadCredit;

        if (credit <= 0) {
            throw new IllegalArgumentException("Guthaben muss positiv sein.");
        }

        if (this.balance > Integer.MAX_VALUE - credit) {
            throw new IllegalArgumentException("Maximaler Guthabenwert überschritten.");
        }

        this.balance += credit;
    }

    public void setBalance(int balance) throws NegativeBalanceException {
        if (balance < 0) {
            throw new NegativeBalanceException("Das Guthaben darf nicht negativ sein.");
        }
        this.balance = balance;
    }

    public void setMaxItems(int anzahl) throws IllegalArgumentException {
        if (anzahl <= 0) {
            throw new IllegalArgumentException("Die maximale Anzahl an Items muss positiv sein.");
        }
        this.maxItems = anzahl;
    }

    public Item getItem(int index) throws IllegalArgumentException {
        if (index < 0 || index >= this.inventory.length) {
            throw new IllegalArgumentException("Ungültiger Index für das Inventar.");
        }
        return this.inventory[index];
    }

    public void setItem(int index, Item artikel) throws IllegalArgumentException {
        if (index < 0 || index >= this.inventory.length) {
            throw new IllegalArgumentException("Ungültiger Index für das Inventar.");
        }
        if (artikel == null) {
            throw new IllegalArgumentException("Das Item darf nicht null sein.");
        }
        this.inventory[index] = artikel;
    }

    public boolean buyItem(Item artikel) throws IllegalArgumentException, NegativeBalanceException {
        if (artikel == null) {
            throw new IllegalArgumentException("Das zu kaufende Item darf nicht null sein.");
        }
        if (this.balance < artikel.cost()) {
            return false;
        }

        for (int i = 0; i < this.inventory.length; i++) {
            if (this.inventory[i] == null) {
                this.inventory[i] = artikel;
                this.setBalance(this.balance - artikel.cost());
                return true;
            }
        }

        if (this.inventory.length < this.maxItems) {
            Item[] laenge = new Item[this.inventory.length + 1];
            for (int i = 0; i < this.inventory.length; i++) {
                laenge[i] = this.inventory[i];
            }
            laenge[this.inventory.length] = artikel;
            this.inventory = laenge;
            this.setBalance(this.balance - artikel.cost());
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        String text = "Account #" + this.accountId + " - Guthaben: " + this.balance + " Gold | Inventar: ";

        boolean erstes = true;
        for (int i = 0; i < this.inventory.length; i++) {
            Item item = this.inventory[i];
            if (item != null) {
                if (!erstes) {
                    text += ", ";
                }
                text += item;
                erstes = false;
            }
        }
        if (erstes) {
            text += "leer";
        }

        return text;
    }

    @Override
    public boolean equals(Object obj) {
        // Gleiche Instanz = gleich
        if (this == obj) {
            return true;
        }
        // Nicht die gleiche Klasse = nicht gleich
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        // Typen-Konvertierung
        Account other = (Account) obj;

        // Account-ID vergleichen
        if (this.accountId != other.accountId) {
            return false;
        }

        // Balance vergleichen
        if (this.balance != other.balance) {
            return false;
        }

        // MaxItems vergleichen
        if (this.maxItems != other.maxItems) {
            return false;
        }

        // Inventory-Länge vergleichen
        if (this.inventory.length != other.inventory.length) {
            return false;
        }

        // Alle Items vergleichen
        for (int i = 0; i < this.inventory.length; i++) {
            // Items holen
            Item item1 = this.inventory[i];
            Item item2 = other.inventory[i];

            // Beide null = ok, weiter
            if (item1 == null && item2 == null) {
                continue;
            }
            // Nur einer null = nicht gleich
            if (item1 == null || item2 == null) {
                return false;
            }
            // Items vergleichen
            if (!item1.equals(item2)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        // Primzahl für Hash-Berechnung
        int prime = 31;
        // Basis-Wert
        int result = 17;

        // Account-ID hashen
        result = result * prime + this.accountId;

        // Balance hashen
        result = result * prime + this.balance;

        // MaxItems hashen
        result = result * prime + this.maxItems;

        // Alle Items durchlaufen
        for (int i = 0; i < this.inventory.length; i++) {
            // Item holen
            Item item = this.inventory[i];
            // Nur nicht-null Items hashen
            if (item != null) {
                result = result * prime + item.hashCode();
            }
        }

        return result;
    }

    @Override
    public String identifier() {
        return String.format("%010d", this.accountId);
    }


}
