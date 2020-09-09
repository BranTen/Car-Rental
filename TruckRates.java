package pkgfinal;

/**
 *
 * @author C. Dierbach
 */
public class TruckRates extends VehicleRates {
  // NOTE: Nothing else to implement. Everything inherited from abstract
  // VehicleRates class.
    
  public TruckRates(double dailyRate, double weeklyRate, double monthlyRate,
                    double perMileChrg, double dailyInsurRate){
          super(dailyRate, weeklyRate, monthlyRate, perMileChrg, dailyInsurRate);
  }
}