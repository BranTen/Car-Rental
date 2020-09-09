package pkgfinal;



import java.util.Scanner;
//import SystemInterface.*;

public class EmployeeUI implements UserInterface {

    private String[] screen_lines;
    private int selected_option;
    private Scanner input;
    boolean quit;

    // constructor
    public EmployeeUI() {
        input = new Scanner(System.in);
    }

    // public method
    public void start() {
        quit = false;

        while (!quit) {
            displayMenu();
            selected_option = getOption();
            execute(selected_option);
        }
    }

    // --- private supporting methods
    private void displayMenu() {

        System.out.println("MAIN MENU – EMPLOYEE\n" +
                            "1 – View Rates\n"+
                            "2 – View Available Vehicles\n"+
                            "3 – Calc Estimated Rental Cost\n"+
                            "4 – Make a Reservation\n"+
                            "5 - Cancel Reservation\n"+
                            "6 – View Corporate Account\n"+
                            "7 – Process Returned Vehicle\n"+
                            "8 - Quit");
    }

    private int getOption() {
        int o = input.nextInt();
        return o;
    }

    private void quit() {
        quit = true;
    }

    private void execute(int cmd) {
        switch (cmd) {
            case 1:
                displayRates();
                break;
            case 2:
                displayAvailVehicles();
                break;
            case 3:
                calcEstimatedRentalCost();
                break;
            case 4:
                makeReservation();
                break;
            case 5:
                cancelReservation();
                break;
            case 6:
                getAccount();
                break;
            case 7:
                processReturnedVehicle();
                break;
            case 8:
                quit();
        }
    }

    private void displayLines(String[] lines) {
        for (int i = 0; i < lines.length; i++){

      //  for (int k = 0; k < lines[i].length(); k++) {
            System.out.println(lines[i]);
       // }
       
    }
    }

    // --- command implementations
    // displays either car, SUV or truck rates
    private void displayRates() {
        System.out.println("1. car rates\n2. suv rates\n3. truck rates");
        int s = input.nextInt();
            if(s == 1){
                screen_lines = SystemInterface.getCarRates();
            }

           if(s == 2){
                screen_lines = SystemInterface.getSUVRates();
           }
           
            if(s == 3){
               screen_lines = SystemInterface.getTruckRates();
        }
               displayLines(screen_lines);
    }

    // displays either available (unreserved), cars, SUVs or trucks
    private void displayAvailVehicles() {
        System.out.println("1. cars \n2. suv \n3. trucks\n4. all");
        int s = input.nextInt();
        //switch (s) {
            if(s == 1)
                screen_lines = SystemInterface.getAvailCars();
            if(s == 2)
                screen_lines = SystemInterface.getAvailSUVs();
            if(s == 3)
                screen_lines = SystemInterface.getAvailTrucks();
            if(s == 4)
                screen_lines = SystemInterface.getAllVehicles();
            
                displayLines(screen_lines);
        
    }

    // calc estimated rental cost
    private void calcEstimatedRentalCost() {
        //getRD();
        screen_lines = SystemInterface.estimatedRentalCost(getRD());
        displayLines(screen_lines);
        System.out.println("you did it");

    }

    private void makeReservation() {
        //getD();
        screen_lines = SystemInterface.makeReservation(getD());
        displayLines(screen_lines);
        System.out.println("you did it");

    }

    private RentalDetails getRD() {
        System.out.println("enter vehicle type \n1. cars \n2. suv \n3. trucks");
        int type = input.nextInt();

        System.out.println("enter rental period");
        String rp = input.next();

        System.out.println("enter number of miles");
        int miles = input.nextInt();

        System.out.println("do you want daily insurance"
                + "\ntrue = yes\nfalse = no");
        boolean b = input.nextBoolean();

        System.out.println("are you a prime customer?"
                + "\ntrue = yes\nfalse = no");
        boolean p = input.nextBoolean();
        RentalDetails rd = new RentalDetails(type, rp, miles, b, p);

        return rd;
    }

    private ReservationDetails getD() {
        System.out.println("enter vin");
        String vin = input.next();
        System.out.println("enter account number");
        String acc = input.next();

        System.out.println("enter rental period");
        String rp = input.next();

        System.out.println("do you want daily insurance"
                + "\ntrue = yes\nfalse = no");
        boolean b = input.nextBoolean();
        ReservationDetails r = new ReservationDetails(vin, acc, rp, b);

        return r;
    }

    private void cancelReservation() {
        System.out.println("enter vin");
        String vin = input.next();

        screen_lines = SystemInterface.cancelReservation(vin);
        displayLines(screen_lines);

    }

    private void getAccount() {
        System.out.println("enter account number");
        String acc = input.next();

        screen_lines = SystemInterface.getAccount(acc);
        displayLines(screen_lines);

    }

    private void processReturnedVehicle() {
        System.out.println("enter vin");
        String vin = input.next();
        System.out.println("enter number of days used");
        int days = input.nextInt();
        System.out.println("enter number of miles");
        int miles = input.nextInt();
        screen_lines = SystemInterface.processReturnedVehicle(vin, days, miles);
        displayLines(screen_lines);
    }
}
