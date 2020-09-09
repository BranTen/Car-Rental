package pkgfinal;

/**
 *
 * @author C. Dierbach
 */
public class SUVRates extends VehicleRates {
  // NOTE: Nothing else to implement. Everything inherited from abstract
  // VehicleRates class.
    
  public SUVRates(double dailyRate, double weeklyRate, double monthlyRate,
                  double perMileChrg, double dailyInsurRate){
          super(dailyRate, weeklyRate, monthlyRate, perMileChrg, dailyInsurRate);
  }
}