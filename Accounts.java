
package pkgfinal;

/**
 *
 * @author C. Dierbach
 */
public class Accounts {
     Account[] accounts;
    private int current_acct;  // for iterator methods
    
    
    public Accounts(){
        accounts = new Account[10]; // assume no more than 10 corporate accounts
        initArray();  // init accounts to all nulls
        current_acct = 0;  // start iteration at first account
    }
    
    
    public void add(Account acct) throws NoAvailVehicleSpaceException {
        accounts[nextAvailIndex()] = acct;
    }
    
    public Account getAccount(String acct_num) throws AccountNotFoundException {
        int i = 0;
        boolean found = false;
        
        while(!found && i < 25 && accounts[i] != null){
            if (accounts[i].getAcctNum().equals(acct_num))
                found = true;
            else
                i = i + 1;
        }
        
        if(found)
            return accounts[i];
        
        throw new AccountNotFoundException();  // if not found
    }
    
    // --- iterator methods
    public void reset(){
        current_acct = 0;
    }
    public Account getA(){
    return accounts[current_acct];
}
    public boolean hasNext(){
        return current_acct < 25 && accounts[current_acct] != null;
    }
    
    public Account getNext(){
        
        if(!hasNext())
            throw new NoMoreAccountsException();
        
        Account return_acct = accounts[current_acct];
        current_acct = current_acct + 1;
        return return_acct;
        
        // the above three lines can be replaced with:
        // return accounts[current_acct++]
        // which increments current_acct AFTER used as index value
    }
    
    // --- private methods
    private void initArray(){
         for(int i = 0; i < 10; i++){
             accounts[i] = null;
         }
    }
    
    private int nextAvailIndex() throws NoAvailAccountSpaceException {
        int i = 0;
        boolean found_null = false;
        
        while(i < 10){
            if (accounts[i] == null)
                return i;
            
            i = i + 1;
        }
        throw new NoAvailAccountSpaceException();
    }    

}

