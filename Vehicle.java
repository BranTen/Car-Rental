
package pkgfinal;


/**
 *
 * @author C. Dierbach
 */
public abstract class Vehicle {
    private String descript; // make and model
    private int mpg; // miles per gallon
    private String vin; // vehicle identification number
    private Reservation resv;  // reservation info (if reserved)
    private Cost cost;  // rates at the time reserved
    
    public Vehicle(String descript, int mpg, String vin){
        this.descript = descript;
        this.mpg = mpg;
        this.vin = vin;
        resv = null;  // init to "unreserved"
        cost = null;  // should be null when no reservation
    }
    
    public String getDescript(){
        return descript;
    }
    
    public int getMPG(){
        return mpg;
    }
    
    public String getVIN(){
        return vin;
    }
    
    public Cost getCost(){
        return cost;
    }
    
    public void setCost(Cost cost){
        this.cost = cost;
    }
    
    public boolean isReserved(){
        return resv != null;
    }
    
    public void reserve(Reservation resv){
        this.resv = resv;
    }
    
    public Reservation getReservation(){
        return resv;
    }
    
    public abstract String toString(); 
    // implemented in each subclass to return the appropriate description, e.g.,
    // "Honda Odyssey mpg: 28  seating: 7  cargo capacity: 6  cubic ft. VIN:VM9RE2645TD

    void cancelReservation() {
resv = null;
        }
}
