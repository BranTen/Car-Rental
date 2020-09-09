
package pkgfinal;


/**
 *
 * @author C. Dierbach
 */
public class Vehicles {
    private Vehicle[] vehs;
    private int current_veh;  // for iterator methods
    
    public Vehicles(){
        vehs = new Vehicle[25]; // assume no more than 25 vehicles
        initArray();  // init vehs to all nulls
        current_veh = 0;  // start iteration at first vehicle
    }
    
    public void add(Vehicle veh) throws NoAvailVehicleSpaceException {
        vehs[nextAvailIndex()] = veh;
    }
    
    public Vehicle getVehicle(String vin) throws VINNotFoundException {
        int i = 0;
        boolean found = false;
        
        while(!found && i < 25 && vehs[i] != null){
            if (vehs[i].getVIN().equals(vin))
                found = true;
            else
                i = i + 1;
        }
        
        if(found)
            return vehs[i];
        
        throw new VINNotFoundException();  // if not found
    }
    
    // --- iterator methods
    public void reset(){
        current_veh = 0;
    }
    
    public boolean hasNext(){
        return current_veh < 25 && vehs[current_veh] != null;
    }
    public Vehicle getV(){
        return vehs[current_veh];
    }
    public Vehicle getNext(){
        
        if(!hasNext())
            throw new NoMoreVehiclesException();
        
        Vehicle return_veh = vehs[current_veh];
        current_veh = current_veh + 1;
        return return_veh;
        
        // the above three lines can be replaced with:
        // return veh[current_veh++]
        // which increments current_veh AFTER used as index value
    }
    
    // --- private methods
    private void initArray(){
         for(int i = 0; i < 25; i++){
             vehs[i] = null;
         }
    }
    
    private int nextAvailIndex() throws NoAvailVehicleSpaceException {
        int i = 0;
        boolean found_null = false;
        
        while(i < 25){
            if (vehs[i] == null)
                return i;
            
            i = i + 1;
        }
        throw new NoAvailVehicleSpaceException();
    }    
}
