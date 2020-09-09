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
class ReservationDetails {
    // constructor variables
    String vin;
    String acctNum;
    String rp;
    boolean dio;
     public ReservationDetails (String vin, String acctNum, String rp, boolean dio){
         this.vin = vin;
         this.acctNum = acctNum;
         this.rp = rp;
         this.dio = dio;
     }
     // getters for the constructoer variables
    public String getVin(){
        return vin;
    }
    public String getAcctNum(){
        return acctNum;
    }
    public String getRp(){
        return rp;
    }
    public boolean getDio(){
        return dio;
    }
}
