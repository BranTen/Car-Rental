/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

/**
 *
 * @author Brandon
 */
class RentalDetails {
    // constructor vatiables
    int vehicleType;
     String estimatedRentalPeriod;
     int estimatedNumMiles;
       Boolean dailyInsur;
        Boolean primeCustomer;
                
    //constructor
    public RentalDetails(int vehicleType, String estimatedRentalPeriod, int estimatedNumMiles,
            Boolean dailyInsur, Boolean primeCustomer) {
        this.vehicleType = vehicleType;
        this.estimatedRentalPeriod = estimatedRentalPeriod;
        this.estimatedNumMiles = estimatedNumMiles;
        this.dailyInsur = dailyInsur;
        this.primeCustomer = primeCustomer;
    }
    // getteres for the variables
    public int getVehicleType(){
        return vehicleType;
    }
    public String getEstRent(){
        return estimatedRentalPeriod;
    }
    public int getEstNumMiles(){
        return estimatedNumMiles;
    }
    public boolean getDailyInsur(){
        return dailyInsur;
    }
    public boolean getPrime(){
        return primeCustomer;
    }
}
