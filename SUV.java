
package pkgfinal;

/**
 *
 * @author C. Dierbach
 */

public class SUV extends Vehicle {
    public String seating;
    public String cargo_capacity;
    
    public SUV(String descript, int mpg, String seating, String cargo_capacity,
               String vin){
        super(descript, mpg, vin);
        this.seating = seating;
        this.cargo_capacity = cargo_capacity;
    }
    
    public String toString(){
        String spacer = "  ";
        return getDescript() + spacer +
               "mpg: " + getMPG() + spacer +
               "seating: " + seating + spacer +
               "cargo capacity: " + cargo_capacity + spacer +
               "VIN: " + getVIN();
    }
}