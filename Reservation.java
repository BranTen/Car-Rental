
package pkgfinal;

/**
 *
 * @author C. Dierbach
 */
public class Reservation {
    private String acctNum; // 5-digit account numbers
    private String companyName;
    private String rentalPeriod;  // e.g., "D4" (four days), "W2" (two weeks),
                                  // "M1" (one month)
    private boolean insuranceSelected;
    
    public Reservation(String acctNum, String companyName, String rentalPeriod,
                       boolean insuranceSelected){
        this.acctNum = acctNum;
        this.rentalPeriod = rentalPeriod;
        this.insuranceSelected = insuranceSelected;
    }
    
    public String getAcctNum(){
        return acctNum;
    }
    
    public String rentalPeriod(){
        return rentalPeriod;
    }
    
    public boolean insuranceSelected(){
        return insuranceSelected;
    }
}
