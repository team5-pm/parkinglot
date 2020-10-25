import java.util.*;
// The building block of ParkingLot 
// This class assists the ParkingLot class by having its own methods and fields which may be used by the ParkingLot class

public class Floor {
    private String floorId;
    private ArrayList<ParkingSpot> parkingSpots;
  //Compact, Large, Handicapped, Motorcycle Spots Counts 
    private int CompactSpotsAvailable;
    private int LargeSpotsAvailable;
    private int HandicappedSpotsAvailable;
    private int MotorcycleSpotsAvailable;
    private int ElectricSpotsAvailable;
    Floor(String floorId,ArrayList<ParkingSpot> parkingSpots) {
        this.floorId = floorId;
        this.parkingSpots = parkingSpots;
        this.CompactSpotsAvailable =0;
        this.LargeSpotsAvailable=0;
        this.HandicappedSpotsAvailable=0;
        this.MotorcycleSpotsAvailable=0;
        this.ElectricSpotsAvailable=0;
        for(ParkingSpot pt : parkingSpots) {
        	this.CompactSpotsAvailable += (pt.getType()=="Compact")?1:0;
        	this.LargeSpotsAvailable += (pt.getType()=="Large")?1:0;
        	this.HandicappedSpotsAvailable += (pt.getType()=="Handicapped")?1:0;
        	this.MotorcycleSpotsAvailable += (pt.getType()=="Motorcycle")?1:0;
        	this.ElectricSpotsAvailable += (pt.getType()=="Electric")?1:0;
        }
    }
    public String getfloorId() {
    	return this.floorId;
    }
    //Returns AvailableSpots of given Type.
    public int getAvailableSpots(String Type) {
    	int ans = 0;
    	switch(Type) {
    		case "Compact":{
    			ans = this.CompactSpotsAvailable;
    			break;
    		}
    		case "Large":{
    			ans = this.LargeSpotsAvailable;
    			break;
    		}
    		case "Handicapped":{
    			ans = this.HandicappedSpotsAvailable;
    			break;
    		}
    		case "Electric":{
    			ans = this.ElectricSpotsAvailable;
    			break;
    		}
    		case "Motorcycle":{
    			ans = this.MotorcycleSpotsAvailable;
    			break;
    		}
    	}
    	return ans;
    }
    // Method overloading
    private void changeAvailableSpots(String Type,boolean increase) {
    	switch(Type) {
    		case "Compact":{
    			this.CompactSpotsAvailable++;
    			break;
    		}
    		case "Large":{
    			this.LargeSpotsAvailable++;
    			break;
    		}
    		case "Handicapped":{
    			this.HandicappedSpotsAvailable++;
    			break;
    		}
    		case "Electric":{
    			this.ElectricSpotsAvailable++;
    			break;
    		}
    		case "Motorcycle":{
    			this.MotorcycleSpotsAvailable++;
    			break;
    		}
    	}
    }
    private void changeAvailableSpots(String Type) {
    	switch(Type) {
    		case "Compact":{
    			this.CompactSpotsAvailable--;
    			break;
    		}
    		case "Large":{
    			this.LargeSpotsAvailable--;
    			break;
    		}
    		case "Handicapped":{
    			this.HandicappedSpotsAvailable--;
    			break;
    		}
    		case "Electric":{
    			this.ElectricSpotsAvailable--;
    			break;
    		}
    		case "Motorcycle":{
    			this.MotorcycleSpotsAvailable--;
    			break;
    		}
    	}
    }
    public ParkingSpot getSpot(String Type) {
    	for(ParkingSpot ps:parkingSpots) {
    		if(ps.isFree() && ps.getType()==Type) {
    			changeAvailableSpots(Type);
    			ps.assign();
    			return ps;
    		}
    	}
    	return parkingSpots.get(0); // will never get to this.
    }
    public void clear(String SpotId) {
    	for(ParkingSpot ps: parkingSpots) {
    		if(ps.getSpotId() == SpotId) {
    			changeAvailableSpots(ps.getType(),true);
    			ps.free();
    		}
    	}
    }
    // Displays Available Spots on this floor
    public void DisplayAvailableSpots() {
		System.out.println("FloorId :"+this.floorId);
		System.out.print("Compact "+getAvailableSpots("Compact")+" ");
		System.out.print("Large "+getAvailableSpots("Large")+" ");
		System.out.print("Handicapped "+getAvailableSpots("Handicapped")+" ");
		System.out.print("Motorcycle "+getAvailableSpots("Motorcycle"));
	}
}