
package pkgfinal;

/**
 *
 * @author C. Dierbach
 */

public class Truck extends Vehicle {
    public String load_capacity;
    
    public Truck(String descript, int mpg, String load_capacity, String vin){
        super(descript, mpg, vin);
        this.load_capacity = load_capacity;
    }
    
    public String toString(){
        String spacer = "  ";
        return getDescript() + spacer +
               "mpg: " + getMPG() + spacer +
               "load capacity: " + load_capacity + spacer +
               "VIN: " + getVIN();
    }
}