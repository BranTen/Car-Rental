package pkgfinal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brandon
 */
public class SystemInterface {
// aggrgator objects
    private static Rates rates;
    private static Vehicles vehicles;
    private static Accounts accounts;
    private static Transactions transactions;   
    public static void initSystemInterface(Rates r, Vehicles v, Accounts a, Transactions t) {
        //construct bjects 
        rates = new Rates();
        vehicles = new Vehicles();
        accounts = new Accounts();
        transactions = new Transactions();
        populateVehicles();
        populateAccounts();
        
    }
    //private methods for testing
    private static void populateVehicles() {
                              //desc  mpg  seats vin
        vehicles.add(new Car("civic", 45, "2", "abc"));
        vehicles.add(new Car("accord", 55, "5", "def"));
                           //desc  mpg  seats  cap    vin
        vehicles.add(new SUV("crv", 35, "6", "20lb", "ghi"));
        vehicles.add(new SUV("pilot", 30, "5", "15lb", "jkl"));
                                   //desc   mpg   cap   vin
        vehicles.add(new Truck("ridgeline", 25, "40lb", "mno"));
        vehicles.add(new Truck("takoma", 15, "30lb", "pqr"));

    }
    private static void populateAccounts() {
                                //acctnum  cn  prime
        accounts.add(new Account("123", "pleb", true));
        accounts.add(new Account("456", "heck", false));
        accounts.add(new Account("789", "plz", true));

    }
    
    // makes account
    public static String[] createAcct(String companyName, String acctNum, boolean prime) {
        String[] responce;
        Account a = new Account(acctNum,companyName,prime);
         //accounts.add1(a);
        responce = new String[4];
        responce[0] = "account created";
        responce[1] = companyName;
        responce[2] = acctNum;
        //if they are a prime member, modify the last the last 
        if (prime) {
            responce[3] = "primeCustomer";
        } else {
            responce[3] = "not prime";
        }
        return responce;
        
    }
    //this method retruns the account information from the given avvount num
    public static String[] getAccount(String acct_num) {        
        String[] s = new String[1];
        s[0] = accounts.getAccount(acct_num).toString();
        return s;
    }
    // this method makes a array of all of the acount information
    public static String[] getAllAccounts() {        
          accounts.reset();
        int i = 0;
        int k = 0;

        while (accounts.hasNext()) {
            if (accounts.getNext() instanceof Account) {
                i++;
            }

        }
        accounts.reset();
        String[] s = new String[i];
        while (accounts.hasNext()) {
            if (accounts.getA() instanceof Account) {
                s[k] = accounts.getA().toString();// add all of the vehicle details into the array
            }
            k++;

            accounts.getNext();
        }

        return s;
      
    }
    
        public static String[] getAllTrans() {        
        int i = 0;
        int k = 0;
        String[] s;        
        while (transactions.hasNext()) {
            transactions.getNext();
            i++;            
        }
        transactions.reset();
        s = new String[i];
        while (transactions.hasNext()) {
            if (transactions.getT() instanceof Transaction) {
                s[k] = transactions.getT().toString();// add all of the vehicle details into the array
            }
            k++;

            accounts.getNext();
        }
        return s;
    }
    // this method returns the details of the car rates
    public static String[] getCarRates() {        
        String[] s = new String[1];
        s[0] = rates.getCarRates().toString();
        return s;
    }
    // this method returns the details of the suv rates
    public static String[] getSUVRates() {        
        String[] s = new String[1];
        s[0] = rates.getSUVRates().toString();
        return s;
    }
    // this method retunr the deatails of the truck rates
    public static String[] getTruckRates() {        
        String[] s = new String[1];
        s[0] = rates.getTruckRates().toString();
        return s;
    }
    // this method puts all of the unreserved cars into the array
    public static String[] getAvailCars() {  
                vehicles.reset();

        int i = 0;        
        while (vehicles.hasNext()) {//as long as there is a vehicle nest 
            if (vehicles.getNext() instanceof Car) { //if the vehicle is the car
                i++;// increment the number of cars
            }            
        }
        vehicles.reset();
        String[] s = new String[i];// create an array of appropriate size for the cars
        for (int k = 0; k < i; k++) {// for all of the cars
            if (vehicles.getV() instanceof Car) {
                s[k] = vehicles.getV().toString();//add deatails of the cars to the array
                
            }
            vehicles.getNext();
            
        }
        
        return s;
    }
// this method adds the details of the availabe suvs into an array
    public static String[] getAvailSUVs() {      
                vehicles.reset();
        int i = 0;        
        int k = 0;
        while (vehicles.hasNext()) {//as long as there is a vehicle nest 
            if (vehicles.getNext() instanceof SUV) { //if the vehicle is the car
                i++;// increment the number of cars
            }            
        }
        vehicles.reset();
        String[] s = new String[i];// create an array of appropriate size for the cars
        
        while (vehicles.hasNext()) {//as long as there is a vehicle nest 
            vehicles.getNext();
            
            if (vehicles.getV() instanceof SUV) { //if the vehicle is the car
                s[k] = vehicles.getV().toString();//add deatails of the cars to the array
                //vehicles.getNext();
                k++;
            }
        }

        return s;
    }
//th9s method adds the details of the trucks into the array
    public static String[] getAvailTrucks() {    
                vehicles.reset();
        int i = 0;        
        int k=0;
        while (vehicles.hasNext()) {//as long as there is a vehicle nest 
            if (vehicles.getNext() instanceof Truck) { //if the vehicle is the car
                i++;// increment the number of cars
            }            
        }
        vehicles.reset();
        String[] s = new String[i];// create an array of appropriate size for the cars
        while (vehicles.hasNext()) {// for all of the cars
            vehicles.getNext();
            if (vehicles.getV() instanceof Truck) {
                s[k] = vehicles.getV().toString();//add deatails of the cars to the array
                k++;
            }
            
        }
        return s;
    }
// this method gets all the vehicle details and adds them into the array 
    public static String[] getAllVehicles() {
        vehicles.reset();
        int i = 0;
        int k = 0;

        while (vehicles.hasNext()) {
            if (vehicles.getNext() instanceof Vehicle) {
                i++;
            }

        }
        vehicles.reset();
        String[] s = new String[i];
        while (vehicles.hasNext()) {
            if (vehicles.getV() instanceof Vehicle) {
                s[k] = vehicles.getV().toString();// add all of the vehicle details into the array
            }
            k++;

            vehicles.getNext();
        }

        return s;
    }
// this method uses the rental details to estimate the cost of the rental
    public static String[] estimatedRentalCost(RentalDetails details) {        
        String[] s = new String[1];        
        double price;
        Rates r = new Rates();
        price = r.calcEstimatedCost(details.getVehicleType(), details.getEstRent(), details.getEstNumMiles(), details.getDailyInsur(), details.getPrime());
        s[0] = "your estimated cost is: " + price + " thank you";
        return s;
    }
// this method makes a reservation with the given info from reservation details 
    public static String[] makeReservation(ReservationDetails details) {        
        String[] s = new String[1];        
        Vehicle v = vehicles.getVehicle(details.getVin());// gets vehicle object from vin
        Account a = accounts.getAccount(details.getAcctNum());
        if (!v.isReserved()) {
            Reservation r = new Reservation(details.getAcctNum(), a.getCn(),details.getRp(), details.getDio()); // creates reservation object
            s[0] = "VIN: " + details.getVin() + " Rental Pariod: " + details.getRp() + " daily insurance" + details.getDio();
            //System.out.println(r.getAcctNum());
            v.reserve(r);
            return s;
        }
        s[0] = "this vehicle is already reserved";
        return s;
    }
// this method gets the reservation details with the given vin 
    public static String[] getReservation(String vin) {        
        String[] s = new String[1];
        
        Vehicle v = vehicles.getVehicle(vin);
        Reservation r = v.getReservation();
        //test fo null
        s[1] = r.toString();
        return s;
    }
// this method puts all of the reservations into an array
    public static String[] getAllReservations() {        
        String[] s ;
        int i = 0;
        int k =0;
        Vehicle v = vehicles.getV();
        vehicles.reset();
        while (vehicles.hasNext()){
            vehicles.getNext();
            i++;
        }vehicles.reset();
        s = new String[i];
        while (vehicles.hasNext()) {
            
            if (v.isReserved()) {
                s[i] = v.getReservation().toString();
            }
            vehicles.getNext();
        }
        
        return s;
    }
// this method finds the reservation belonging to the vehicle with the matching vin 
    public static String[] cancelReservation(String vin) {        
        String[] s = new String[1];
        Vehicle v = vehicles.getVehicle(vin);
        if (v.isReserved()) {// if the vehicle is reserved then cancel it
            v.cancelReservation();
            s[0] = "you did it";
        } else {
            //throw exception
        }
        return s;
    }
// this method calculates the cst of the rental and deletes the current reservation
    public static String[] processReturnedVehicle(String vin, int numDaysUsed, int numMilesDriven) {
// calcuate actual cost
// delete the current reservation
        String[] s = new String[1];       
        // create all of these objects from using the vin to get the specific details
        Vehicle v = vehicles.getVehicle(vin);
        Reservation r = v.getReservation();
        Account a = accounts.getAccount(r.getAcctNum());
        VehicleRates car = rates.getCarRates();
        VehicleRates SUV = rates.getSUVRates();
        VehicleRates Truck = rates.getTruckRates();
        // convert the values to fit the paramaters
        double price = 0;
        String vt = "";
        // find out what vehicle it is and calculate the cost for whatever vehicle it is
        if (v instanceof Car) {
            price = rates.calcActualCost(car, numDaysUsed, numMilesDriven, r.insuranceSelected(), a.primeCustomer());
            vt = "car";
        } else {
            if (v instanceof SUV) {
                price = rates.calcActualCost(SUV, numDaysUsed, numMilesDriven, r.insuranceSelected(), a.primeCustomer());
                vt = "SUV";
            } else {
                if (v instanceof Truck) {
                    price = rates.calcActualCost(Truck, numDaysUsed, numMilesDriven, r.insuranceSelected(), a.primeCustomer());
                    vt = "Truck";
                }
            }
        } // convert the values to fir the paramaters
        String rd = "" + numMilesDriven;
        String rp = "" + numDaysUsed;
        String c = "" + price;
        s[0] = "your total will be $" + price + "process completed!";
        Transaction t = new Transaction(rd, r.getAcctNum(), a.getCn(), vt, rp, c);
        transactions.add(t); // add this process to the transaction
        v.cancelReservation(); // delete the reservation
        
        return s;
    }
    
}
