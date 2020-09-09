package pkgfinal;


import java.util.Scanner;

public class ManagerUI implements UserInterface {
    
    private String[] screen_lines;
    private int selected_option;
    private Scanner input;
    boolean quit;

    // constructor
    public ManagerUI() {
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

        System.out.println("MAIN MENU – MANAGER\n" +
                            "1 – add accounts\n"+
                            "2 – update rates\n"+
                            "3 – view vehicles\n"+
                            "4 – view reservation\n"+
                            "5 - view accounts\n"+
                            "6 – view transactions\n"+
                            "7 - Quit");
    }

    private int getOption() {
        int o = input.nextInt();
        return o;
    }

    private void quit() {
        quit = true;
    }
    private void displayLines(String[] lines) {
     for (int i = 0; i < lines.length; i++){

      //  for (int k = 0; k < lines[i].length(); k++) {
            System.out.println(lines[i]);
       // }
     }
     
    }
    private void execute(int cmd) {
        switch (cmd) {
            case 1:
                addAccount();
                break;
            case 2:
                updateRates();
                break;
            case 3:
                viewVehicles();
                break;
            case 4:
                viewResv();
                break;
            case 5:
                viewAccts();
                break;
            case 6:
                viewTrans();
                break;
            case 7:
                quit();
        }
    }

    private void addAccount() {
        System.out.println("enter company name:");
        String cn = input.next();
        System.out.println("enter account number");
        String an = input.next();
        System.out.println("are you a prime customer?"
        + "\ntrue = yes\nfalse = no");
        boolean p = input.nextBoolean();
        SystemInterface.createAcct(cn, an, p);
        System.out.println("account added");
    }

    private void updateRates() {
        System.out.println("enter vehicle type to update rate\n1. cars \n2. suv \n3. trucks");
        int cmd = input.nextInt();
        System.out.println("enter daily rate");
        int dr = input.nextInt();
                System.out.println("enter weekly rate");
        int wr = input.nextInt();
                System.out.println("enter monthly rate");
        int mr = input.nextInt();
                System.out.println("enter mileage charge");
        int mc = input.nextInt();
                System.out.println("enter daily insurance rate");
        int di = input.nextInt();
                switch (cmd) {
            case 1:
                CarRates c = new CarRates(dr,wr,mr,mc,di);
                break;
            case 2:
                SUVRates s = new SUVRates(dr,wr,mr,mc,di);
                break;
            case 3:
                TruckRates t = new TruckRates(dr,wr,mr,mc,di);
                break;

        }
System.out.println("rates updated");
    }

    private void viewVehicles() {
                      screen_lines = SystemInterface.getAllVehicles();
        displayLines(screen_lines);
    }

    private void viewResv() {
                screen_lines = SystemInterface.getAllReservations();
        displayLines(screen_lines);
    }

    private void viewAccts() {
                screen_lines = SystemInterface.getAllAccounts();
        displayLines(screen_lines);
    }

    private void viewTrans() {
                screen_lines = SystemInterface.getAllTrans();
        displayLines(screen_lines);
    }
}
