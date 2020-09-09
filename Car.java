
package pkgfinal;

/**
 *
 * @author C. Dierbach
 */
public class Car extends Vehicle {
    public String seating;
    
    public Car(String descript, int mpg, String seating, String vin){
        super(descript, mpg, vin);
        this.seating = seating;
    }
    
    public String toString(){
        String spacer = "  ";
        return getDescript() + spacer +
               "mpg: " + getMPG() + spacer +
               "seating: " + seating + spacer +
               "VIN: " + getVIN();
    }
}