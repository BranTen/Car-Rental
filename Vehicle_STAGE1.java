
//package TestDriver;

/**
 *
 * @author C. Dierbach
 */
import java.util.Scanner;
import pkgfinal.Accounts;
import pkgfinal.EmployeeUI;
import pkgfinal.ManagerUI;
import pkgfinal.SystemInterface;
import pkgfinal.Rates;
import pkgfinal.Transactions;
import pkgfinal.Vehicles;


//import utilities.*;

public class Vehicle_STAGE1 {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        EmployeeUI emp = new EmployeeUI();
        ManagerUI mgr = new ManagerUI();
        Rates r = new Rates();
        Vehicles v = new Vehicles();
        Accounts a = new Accounts();
        Transactions t = new Transactions();
        SystemInterface.initSystemInterface(r, v, a, t);
        int choice = 0;
        System.out.println("are you an employee(1) or manager(2)");
       choice = in.nextInt();
       
       if(choice == 1){
           emp.start();
       }
       if(choice == 2){
           mgr.start();
       }
    }

    }
       /*
        int selection;
        boolean all = false;
        
        displayMenu();
        prt("Enter: ");
        selection = getSelection();
        
        while(selection != 9){
            switch(selection){
                case 1: all = true;
                case 2: testVehicleUtilitiesClass(); 
                        if(!all) break;
                case 3: testVehiclesClass();
                        if(!all) break;
                case 9: prtln("Goodbye ..."); break;
                default: prtln("* INVALID SELECTION *");
                         skipLine();
            }
            
            skipLine();
            displayMenu();
            prt("Enter: ");
            selection = getSelection();
        }
        
    }
    
    // ------------------------------------------------------------------------
       public static void testVehicleUtilitiesClass(){
    // ------------------------------------------------------------------------
    
    // --- TESTING: Throws exception when getVehicle called and no vehicles exist
           
        displayTestingBanner("Testing VehicleUtilities Class");
        
        // test rental period string related methods
        displayRentalPeriodParseTesting("D1"); skipLine();
        displayRentalPeriodParseTesting("W4"); skipLine();
        displayRentalPeriodParseTesting("M2"); skipLine();
                
        // test for InvalidRentalPeriodFormatException
        String rentalPeriodStr = "X0";
        
        try{
            displayRentalPeriodParseTesting(rentalPeriodStr);
        }
        catch (InvalidRentalPeriodFormatException e)
        {
            RESULT("Calling rental period related methods with invalid " + 
                   "rental period string " + rentalPeriodStr,
                   true, "",
                   "InvalidRentalPeriodFormatException thrown");
        }
        
        // test method rentalPeriodConstruction(numDays)for numDays < 7,
        // 7 < numDays < 30, and numDays > 30, as well as method numExcessDays
        displayRentalPeriodConstructionTesting(1); skipLine();
        displayRentalPeriodConstructionTesting(8); skipLine();
        displayRentalPeriodConstructionTesting(34); skipLine();
    }
        
        
    
    // ------------------------------------------------------------------------
        public static void testVehiclesClass(){
    // ------------------------------------------------------------------------
    
    // --- TESTING: Throws exception when getVehicle called and no vehicles exist
           
    displayTestingBanner("Testing Vehicles Class");

    // create Vehicles object (initially empty)
    vehs = new Vehicles();

    // call to getVehicle should throw exception
    boolean VINNotFoundExceptionThrown = false;

    VIN = "AAA111";
    try{
        vehs.getVehicle(VIN);
    }
    catch (VINNotFoundException e){
        VINNotFoundExceptionThrown = true;
    }

    RESULT("Calling getVehicle(" + VIN + ") when no vehicles exist\n" +
            "VINNotFoundException should be thrown",
            VINNotFoundExceptionThrown,
            "VINNotFoundException Thrown",
            "VINNotFoundException not Thrown");


    // --- TESTING: Iterates through vehicles when only one exists

    VIN =  "ABC123";
    new_vehicle = new Car("CAR1", 32, "5", VIN);
    vehs.add(new_vehicle);
    prtln("ADDED: " + new_vehicle.toString()); 
    skipLine();

    prtln("Iterating through vehicles when only one");

    vehs.reset();
    while(vehs.hasNext())
    {
        veh = vehs.getNext();
        prtln(veh.toString());
    }

    // --- TESTING: Finds vehicle when only one that exists

    skipLine();
    VINNotFoundExceptionThrown = false;

    try{
        veh = vehs.getVehicle("ABC123");
    }
    catch (VINNotFoundException e){
        VINNotFoundExceptionThrown = true;
    }

    RESULT("Calling getVehicle(" + VIN + ") when only existing vehicle",
            !VINNotFoundExceptionThrown,
            "Vehicle " + VIN + " Found",
            "Vehicle " + VIN + " not Found");


    new_vehicle = new Car("CAR2", 33, "6", "DEF456");
    vehs.add(new_vehicle);
    prtln("ADDED: " + new_vehicle.toString()); 

    new_vehicle = new Car("CAR3", 34, "7", "GHI789");
    vehs.add(new_vehicle);
    prtln("ADDED: " + new_vehicle.toString()); 
    skipLine();

    // --- TESTING: Iterates through vehicles when more than one exists

    prtln("Iterating through vehicles when more than one exists");

    vehs.reset();
    while(vehs.hasNext())
    {
        veh = vehs.getNext();
        prtln(veh.toString());
    }
    skipLine();

    // --- TESTING: Finds vehicle when more than one exists

    VINNotFoundExceptionThrown = false;

    VIN = "DEF456";
    try{
        veh = vehs.getVehicle(VIN);
    }
    catch (VINNotFoundException e){
        VINNotFoundExceptionThrown = true;
    }

    RESULT("Calling getVehicle(" + VIN + ") when one of many vehicles",
            !VINNotFoundExceptionThrown,
            "Vehicle " + VIN + " Found",
            "Vehicle " + VIN + " not Found");

    // --- TESTING: Throws exception when vehicle searching for does not exist

    VINNotFoundExceptionThrown = false;
    VIN = "XYZ999";
    try{
        veh = vehs.getVehicle(VIN);
        prtln(veh.toString());
    }
    catch (VINNotFoundException e){
        VINNotFoundExceptionThrown = true;
    }

    RESULT("Calling getVehicle with non-existing VIN " + VIN,
            VINNotFoundExceptionThrown,
            "Vehicle " + VIN + " not found",
            "Vehicle " + VIN + " found");

}
    // ---------------------------------------------------------------------
    // private methods
    // ---------------------------------------------------------------------
   
    private static void skipLine(){
        System.out.println();
    }
    
    private static void prt(String line){
        System.out.print(line);
    }
    
    private static void prtln(String line){
        System.out.println(line);
    }
    
    private static void displayAsterisks(int numAst){
        for(int i = 0; i < numAst; i++)
            System.out.print("*");
        System.out.println();
    }
    
    private static void displayTestingBanner(String title){
        displayAsterisks(55);
        prtln(title);
        displayAsterisks(55);
    }
    
    private static void displayMenu(){
        prtln("1 - Complete Testing");
        prtln("2 - Vehicle_Utilities Class Testing");
        prtln("3 - Vehicles Class Testing");
        prtln("9 - Quit");
    }
    
    private static int getSelection(){
        int selection= 0;
        
        boolean valid_input = false;
        
        while(!valid_input){
            try{
                selection = input.nextInt();
                valid_input = true;
            }
            catch(InputMismatchException e){
                prtln("* Invalid Selection");}
        }
            
        return selection;
    }
    
    private static void displayRentalPeriodParseTesting(String p) 
                                throws InvalidRentalPeriodFormatException{
        prtln("Testing methods timeUnit, timePeriod and dailyRate for " + p);
        
        prtln("Time Unit: " + Vehicle_Utilities.timeUnit(p));
        prtln("Time Period: " + Vehicle_Utilities.timePeriod(p));
        
        if(Vehicle_Utilities.dailyRate(p))
            prtln("* Daily Rate *");
        else
            if(Vehicle_Utilities.weeklyRate(p))
                prtln("* Weekly Rate *");
                else
                if(Vehicle_Utilities.monthlyRate(p))
                    prtln("* Monthly Rate *");
    }
    
    private static void displayRentalPeriodConstructionTesting(int numDays){
        prtln("Testing construction of rental period str for " + numDays +
               " days");
        
        String rentalPeriodStr = 
                      Vehicle_Utilities.constructRentalPeriodStr(numDays);
                
        prtln("Rental Period String: " + rentalPeriodStr + 
              ", Num Excess Days: " + 
              Vehicle_Utilities.numExcessDays(numDays, rentalPeriodStr));
                        
    }
    
    private static void RESULT(String test_condition, boolean passed_test,
                               String passed_mesg, String failed_mesg){
        prtln(test_condition);
        
        if(passed_test)
            prtln("** PASSED: " + passed_mesg + " **");
        else
            prtln("## FAILED: " + failed_mesg + " ##");
        
        prtln("");  // skip line
    }
   
}
*/