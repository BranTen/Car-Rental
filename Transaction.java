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
public class Transaction {
private String return_datetime;;
private String acct_num; // five-digit acct number
private String company_name;
private String vehicle_type; // car, SUV or Truck
private String rental_period; // days, week, months
private String rental_cost;
// constructor 
public Transaction(String rd, String an, String cn,
                   String vt, String rp, String rc){
    return_datetime = rd;
    acct_num = an;
    company_name = cn;
    vehicle_type = vt;
    rental_period = rp;
    rental_cost = rc;
}
// to string
public String toString(){
    return    "Return date/time: " + return_datetime + 
            "\nAccount #: " + acct_num +
            "\nCompany Name: " + company_name +
            "\nVehicle Type: " + vehicle_type +
            "\nRental Period" + rental_period + 
            "\nRental Cost: " + rental_cost;
}


}
