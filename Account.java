
package pkgfinal;

/**
 *
 * @author C. Dierbach
 */
public class Account {
    private String acct_num;
    private String company_name;
    private String[] vehicles_reserved;
    private boolean prime_customer;
    
    public Account(String acct_num, String company_name, boolean prime_customer){
        this.acct_num = acct_num;
        this.company_name = company_name;
        this.prime_customer = prime_customer;
        vehicles_reserved = new String[10]; // init for max 10 vehicles
        Accounts a = new Accounts();
        a.add(this);
    }
    
    public String getAcctNum(){
        return acct_num;
    }
    
    public String[] getVehiclesReserved(){
        return vehicles_reserved;
    }
    
    public boolean primeCustomer(){
        return prime_customer;
    }
    
    public String toString(){
        String spacer = "   ";
        String primecustomer_str = "";  // init to empty string
        String reservedvehicles_str = ""; // init to empty string
        
        if(prime_customer) 
            primecustomer_str = "* Prime Customer *";
        
        if(vehicles_reserved[0] != null)
            reservedvehicles_str = "* Currently Reserved Vehicles";
        
        return company_name + spacer +  "acct num " + acct_num + spacer + 
               primecustomer_str + spacer + reservedvehicles_str;
    }

    String getCn() {
        return company_name;
    }
}
