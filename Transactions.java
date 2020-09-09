package pkgfinal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brandon
 */
import java.util.ArrayList;

public class Transactions {

    private ArrayList<Transaction> transaction = new ArrayList<Transaction>();
    int i = 0;// this value is to count and iterate through the array

    public Transactions() {
    }
// adds a transaction object to the array
    public void add(Transaction t) {
        transaction.add(t);
    }
    public Transaction getT(){
        return transaction.get(i);
    }
    public void reset() {
        i = 0;// sets the iterator back to the first spot
    }
// this method returns true if the next value is not null
    public boolean hasNext() {
        
        if (getNext() == null) {
            return false;
        }
        i++;// increment the number 
        return true;
    }

    public Transaction getNext() {
        return transaction.get(i + 1);// gets the next transaction in the array
    }

}
