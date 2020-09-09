
package pkgfinal;

/**
 *
 * @author C. Dierbach
 */
public class CarRates extends VehicleRates {
  // NOTE: Nothing else to implement. Everything inherited from abstract
  // VehicleRates class.
    
  public CarRates(double dailyRate, double weeklyRate, double monthlyRate,
                  double perMileChrg, double dailyInsurRate){
          super(dailyRate, weeklyRate, monthlyRate, perMileChrg, dailyInsurRate);
  }
public String toString(){
    return" you done it";
}
}
