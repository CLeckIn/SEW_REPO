package Interfaces;

import Exceptions.NegativeBalanceException;
import account_item.Item;

public interface UserAccount {
    int getBalance();
    void increaseBalance(double uploadCredit);
    boolean buyItem(Item item) throws NegativeBalanceException;
}
