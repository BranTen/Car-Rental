
package pkgfinal;

/**
 *
 * @author C. Dierbach
 */
public class Vehicle_Utilities {
    
// --------------------------------------------------------------------------
// Provides (static) methods for parsing the parts of a rental period string

// Rental Period formatted string:  <time unit><time period>,
// where
//        <time unit> = 'D' (daily), 'W' (weekly), 'M' (monthly)
//        <time period>  1, 2, 3, ...        
// e.g.,
//        D4 - daily rental for 4 days
// --------------------------------------------------------------------------  
    
    public static char timeUnit(String rentalPeriodStr) 
                                         throws InvalidRentalPeriodFormatException {
    // returns time unit part of rental period: 'D', 'W', or 'M'
        
        char firstChar = rentalPeriodStr.charAt(0);
        if(firstChar != 'D' && firstChar != 'W' && firstChar != 'M')
            throw new InvalidRentalPeriodFormatException();
       
        return firstChar;
    }
    
    public static int timePeriod(String rentalPeriodStr) 
                                      throws InvalidRentalPeriodFormatException{
    // returns time period part of rental period (as integer)
        
      try{
        String length_str =  rentalPeriodStr.substring(1); // all but first char
        return Integer.valueOf(length_str); // static method valueOf of Integer class
      }
      catch(IndexOutOfBoundsException e){
          throw new InvalidRentalPeriodFormatException();
      }
      catch(NumberFormatException e){
          throw new InvalidRentalPeriodFormatException();
      }
    }
       
    // convenience methods
    public static boolean dailyRate(String rentalPeriodStr){
        if(timeUnit(rentalPeriodStr) == 'D')
            return true;
        return false;
    }

    public static boolean weeklyRate(String rentalPeriodStr){
        if(timeUnit(rentalPeriodStr) == 'W')
            return true;
        return false;
    }

    public static boolean monthlyRate(String rentalPeriodStr){
        if(timeUnit(rentalPeriodStr) == 'M')
            return true;
        return false;
    }
    
    public static String constructRentalPeriodStr(int numDays){
    
    // returns a string formatted for daily rental period if numDays < 7
    // returns a string formatted for weekly rental period if 7 < numDays < 30
    // otherwise, returns a string formatted for monthly rental
        
        String numDaysStr = Integer.toString(numDays);
        
        if(numDays < 7)
            return "D" + numDaysStr;
        else
            if (numDays < 30)
                return "W" + numDaysStr;
            else 
                return "M" + numDaysStr;
    }
    
    public static int numExcessDays(int numDaysUsed, String rentalPeriodStr){
    
    // returns the number of days in excess of a given rental period type
    // if rental period is daily, 0
    // if rental period is weekly, returns numDaysUsed mod 7
    // if rental period is monthly, returns numdaysUsed mod 30
        
        int num_excess_days = 0;
        
        // for daily rate, number of excess days is 0
        
        if(weeklyRate(rentalPeriodStr)){
            num_excess_days =  numDaysUsed % 7;
        }
        
        if(monthlyRate(rentalPeriodStr)){
            num_excess_days =  numDaysUsed % 30;
        }
        
        return num_excess_days;
    }
}
