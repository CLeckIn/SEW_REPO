package account_item.premiumAccount;

import account_item.Account;
import account_item.Item;
import Exceptions.NegativeBalanceException;

public class PremiumAccount extends Account {

    private int premiumFee;
    private double discountRate;
    private boolean feeCharged;

    public PremiumAccount(int accountId, int balance, int maxItems, int premiumFee, double discountRate) throws IllegalArgumentException, NegativeBalanceException {
        super(accountId, balance, maxItems);
        this.premiumFee = 0;
        this.discountRate = 0.0;
        this.feeCharged = false;

        this.setPremiumFee(premiumFee);
        this.setDiscountRate(discountRate);
    }

    public PremiumAccount() throws NegativeBalanceException, IllegalArgumentException {
        super();
        this.premiumFee = 0;
        this.discountRate = 0.0;
        this.feeCharged = false;

        this.setPremiumFee(10);
        this.setDiscountRate(0.1);
    }

    public void setPremiumFee(int premiumFee) throws IllegalArgumentException {
        if (premiumFee <= 0) {
            throw new IllegalArgumentException("Die Premium-Gebühr muss positiv sein.");
        }
        this.premiumFee = premiumFee;
    }

    public void setDiscountRate(double discountRate) throws IllegalArgumentException {
        if (discountRate < 0 || discountRate > 1) {
            throw new IllegalArgumentException("Die Rabattrate muss zwischen 0.0 und 1.0 liegen.");
        }
        this.discountRate = discountRate;
    }

    public void chargeMonthlyFee() throws NegativeBalanceException {
        if (!this.feeCharged) {
            if (this.getBalance() < this.premiumFee) {
                throw new NegativeBalanceException("Nicht genug Guthaben, um die Monatsgebühr von " + this.premiumFee + " Gold abzubuchen.");
            }
            this.setBalance(this.getBalance() - this.premiumFee);
            this.feeCharged = true;
        }
    }

    @Override
    public boolean buyItem(Item item) throws IllegalArgumentException, NegativeBalanceException {
        if (item == null) {
            throw new IllegalArgumentException("Das zu kaufende Item darf nicht null sein.");
        }

        // Rabatt-Preis berechnen
        int rabattPreis = (int) Math.round(item.cost() * (1.0 - this.discountRate));

        // Neues Item mit rabattiertem Preis erstellen (da Record immutable ist)
        Item rabattItem = new Item(item.name(), rabattPreis);
        
        // Mit rabattiertem Item kaufen
        boolean gekauft = super.buyItem(rabattItem);
        
        // Falls nicht gekauft, das ursprüngliche Item zurückgeben
        if (gekauft) {
            return true;
        }
        
        return false;
    }

    @Override
    public String toString() {
        String status = this.feeCharged ? "bereits bezahlt" : "noch nicht bezahlt";

        return "*" + super.toString() +
                " - Premium-Account (" + this.premiumFee + " Gold/Monat; "
                + (this.discountRate * 100) + "% Rabatt; " + status + ")";
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
        PremiumAccount other = (PremiumAccount) obj;

        // Erst Parent-Klasse vergleichen
        if (!super.equals(other)) {
            return false;
        }

        // PremiumFee vergleichen
        if (this.premiumFee != other.premiumFee) {
            return false;
        }

        // DiscountRate vergleichen
        if (Double.compare(this.discountRate, other.discountRate) != 0) {
            return false;
        }

        // FeeCharged vergleichen
        if (this.feeCharged != other.feeCharged) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        // Primzahl für Hash-Berechnung
        int prime = 31;
        // Parent-Hash als Basis verwenden
        int result = super.hashCode();

        // PremiumFee hashen
        result = result * prime + this.premiumFee;

        // DiscountRate hashen
        result = result * prime + Double.hashCode(this.discountRate);

        // FeeCharged hashen (0 oder 1)
        result = result * prime + (this.feeCharged ? 1 : 0);

        return result;
    }
}
