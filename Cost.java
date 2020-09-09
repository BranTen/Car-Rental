
package pkgfinal;

/**
 *
 * @author C. Dierbach
 */
public class Cost {
    private double dailyRate;
    private double weeklyRate;
    private double monthlyRate;
    private double perMileCharge;
    private double dailyInsurRate;
    
    public Cost(double daily, double weekly, double monthly, 
                double perMile, double dailyInsur){
        dailyRate = daily;
        weeklyRate = weekly;
        monthlyRate = monthly;
        perMileCharge = perMile;
        dailyInsurRate = dailyInsur;
    }
    
    public double getDailyRate(){
        return dailyRate;
    }
    
    public double getWeeklyRate(){
        return weeklyRate;
    }
    
    public double getMonthlyRate(){
        return monthlyRate;
    }
    
    public double getPerMileCharge(){
        return perMileCharge;
    }
    
    public double getDailyInsurance(){
        return dailyInsurRate;
    }
    
}
