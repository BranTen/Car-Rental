
package pkgfinal;

//import utilities.*;

/**
 *
 * @author C. Dierbach
 * 
 * The Rates class maintains the current sets of rates for Cars, SUVs, and Trucks.
 * Each set of rates is stored in its own VehicleRates object (for subtypes
 * CarRates, SUVRates, TruckRates), each containing the following rate information:
 * 
 *   daily rate, weekly rate, monthly rate, per mile charge, daily insur rate
 * 
 * Getter and setters for each rate type for retrieving and updating the current
 * rates.
 * 
 * In addition, two calculation methods are provided:
 * 
 * calcEstimatedCostint(vehicleType, estRentalPeriod, estNumMiles, 
 *                      dailyInsur, primeCustomer)
 * 
 *    calculates the ESTIMATED cost of a rental (for a given vehicle type,
 *    estimated rental period, estimated number of miles to be driven,
 *    whether daily insurance selected, and if prime customer.
 * 
 * calcActualCost(vehicleType, estRentalPeriod, estNumMiles, 
 *                      dailyInsur, primeCustomer)
 * 
 *    calculates the ACTUAL cost of a returned vehicle (for a set of rates as they
 *    were at the time the vehicle was reserved, the number of days used, the
 *    number of miles driven, whether daily insur selected, and whether a prime
 *    customer.
 */

public class Rates {
    private CarRates currentCarRates;
    private SUVRates currentSUVRates;
    private TruckRates currentTruckRates;
    
    // Constructor
    public Rates(){
    // sets each set of rates to current rates: daily, weekly, monthly,
    // daily per mile charge, and optional daily insurance rate
        
        currentCarRates = new CarRates(24.95, 149.95, 514.95, 0.15, 14.95);
        currentSUVRates = new SUVRates(29.95, 189.95, 679.95, 0.15, 14.95);
        currentTruckRates = new TruckRates(34.95, 224.95, 797.95, 0.26, 22.95);
    }
    
    // setters and getters
    
    public CarRates getCarRates(){
        return currentCarRates;
    }
    
    public SUVRates getSUVRates(){
        return currentSUVRates;
    }
    
    public TruckRates getTruckRates(){
        return currentTruckRates;
    }
    
    public void setCarRates(CarRates r){
        currentCarRates = r;
    }
    
    public void setSUVRates(SUVRates r){
        currentSUVRates = r;
    }
    
    public void setTruckRates(TruckRates r){
        currentTruckRates = r;
    }
    
    // cost calculation methods
    public double calcEstimatedCost(int vehicleType, String estRentalPeriod,
                                    int estNumMiles, Boolean dailyInsur,
                                    boolean primeCustomer)
                                    throws InvalidRentalPeriodFormatException {
    // calculates rental cost for estimated time period to use, estimated
    // number of miles driven, whether daily insurance desired, and
    // whether a prime customer (prime customers get 100 free miles per rental)
        
        VehicleRates v_rates = null;
        double charge;
        
        // retrieve current rates for vehicle type
        switch(vehicleType){
            case 1: v_rates = currentCarRates; break;
            case 2: v_rates = currentSUVRates; break;
            case 3: v_rates = currentTruckRates; break;
        }
        
        // extract time period from (estimated) rental period string
        int time_period = Vehicle_Utilities.timePeriod(estRentalPeriod);
        
        // calc basic rental charge
        if(Vehicle_Utilities.dailyRate(estRentalPeriod))
            charge = v_rates.getDailyRate() * time_period;
        else
            if(Vehicle_Utilities.weeklyRate(estRentalPeriod))
                charge = v_rates.getWeeklyRate() * time_period;
            else
                if(Vehicle_Utilities.monthlyRate(estRentalPeriod))
                    charge = v_rates.getMonthlyRate() * time_period;
                else
                    throw new InvalidRentalPeriodFormatException();
        
        // include estimated mileage charge
        charge = charge + estNumMiles * v_rates.getPerMileCharge();
        
        return charge;
   }   
    
   public double calcActualCost(VehicleRates v_rates, int numDaysUsed,
                                int numMilesDriven, Boolean dailyInsur,
                                boolean primeCustomer){
   // calculates rental costs for provided rental rates, number of days used, 
   // number of miles driven, whether daily insurance was selected, and
   // whether a prime customer (prime customers get 100 free miles each rental).
       
        double charge;
        
        // construct formatted rental period string for numDaysUsed
        String rentalPeriodStr = 
                Vehicle_Utilities.constructRentalPeriodStr(numDaysUsed);
        
        // calc basic charge based on numDayUsed only
        charge = calcBasicCharge(v_rates,rentalPeriodStr); 
        
        // add mileage charge
        charge = charge + calcMileageCharge(numMilesDriven, v_rates,
                                            primeCustomer);
        
        charge = charge + calcDailyInsurCharge(numDaysUsed, v_rates);
        
        return charge;
   }  
   
   // private methods
   private double calcBasicCharge(VehicleRates v_rates, String rentalPeriodStr)
                                throws InvalidRentalPeriodFormatException{
   // returns the basic charge based on the number of days used only.
       
        double basic_charge;
        int time_period = Vehicle_Utilities.timePeriod(rentalPeriodStr);
        
        if(Vehicle_Utilities.dailyRate(rentalPeriodStr))
            basic_charge = v_rates.getDailyRate() * time_period;
        else
            if(Vehicle_Utilities.weeklyRate(rentalPeriodStr))
                basic_charge = v_rates.getWeeklyRate() * time_period;
            else
                if(Vehicle_Utilities.monthlyRate(rentalPeriodStr))
                    basic_charge = v_rates.getMonthlyRate() * time_period;
                else
                    throw new InvalidRentalPeriodFormatException();
        
        return basic_charge;
   }
   
   private double calcMileageCharge(int numMiles, VehicleRates v_rates,
           boolean primeCustomer){
   // returns mileage charge based on provided numMiles and v_rates.
   // if prime customer, mileage is reduced by 100 miles.
       
       double mileage_charge = 0;
       
       if(primeCustomer)
           numMiles = numMiles - 100;
       
       if(numMiles > 0){
           mileage_charge =  numMiles * v_rates.getPerMileCharge();
       }
       
       return mileage_charge;
   }
   
   private double calcDailyInsurCharge(int numDays, VehicleRates v_rates){
   // returns daily insurance charge based on provided numDaysUsed and v_rates.
       
       double insur_charge = 0;
       insur_charge =  numDays * v_rates.getDailyInsurCharge();
   
       return insur_charge;
   }
}
