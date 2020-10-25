// Encapsulation : Fields are declared private and can be accessed only through getter functions
// Abstraction : As all the Spots have the same body Abstraction is used, also helps in working with the various spot classes
abstract class ParkingSpot{
	public abstract boolean isFree(); // Is the spot free? 
	public abstract void assign(); // Assigns the spot to a vehicle
	public abstract String getType(); // Returns the Type (Size) of the Spot
	public abstract void free(); // Frees the Spot
	public abstract String getSpotId(); // Returns UniqueId associated with the Spot
}
//Compact, Large, Handicapped, Motorcycle - multiple classes so that changes concerning specific spots can be made easily
class CompactSpot extends ParkingSpot{
	private String Type,spotId;
	private boolean free;
	CompactSpot(String Id){
		Type = "Compact";
		free = true;
		spotId = Id;
	}
	public String getType() {
		return Type;
	}
	public boolean isFree() {
		return free;
	}
	public void assign() {
		free = false;
	}
	public void free() {
		this.free = true;
	}
	public String getSpotId() {
		return this.spotId;
	}
}
class LargeSpot extends ParkingSpot{
	private String Type,spotId;
	private boolean free;
	LargeSpot(String Id){
		free = true;
		Type = "Large";
		spotId = Id;
	}
	public String getType() {
		return Type;
	}
	public boolean isFree() {
		return free;
	}
	public void assign() {
		free = false;
	}
	public void free() {
		this.free = true;	
	}
	public String getSpotId() {
		return this.spotId;
	}
}
class HandicappedSpot extends ParkingSpot{
	private String Type,spotId;
	private boolean free;
	public ParkTicket pt;
	HandicappedSpot(String Id){
		free = true;
		Type = "Handicapped";
		spotId = Id;
	}
	public String getType() {
		return Type;
	}
	public boolean isFree() {
		return free;
	}
	public void assign() {
		free = false;
	}

	public void free() {
		this.free = true;
	}
	public String getSpotId() {
		return this.spotId;
	}
}
class MotorcycleSpot extends ParkingSpot{
	private String Type,spotId;
	private boolean free;
	MotorcycleSpot(String Id){
		free = true;
		Type = "Motorcycle";
		spotId = Id;
	}
	public String getType() {
		return Type;
	}
	public boolean isFree() {
		return free;
	}
	public void assign() {
		free = false;
	}

	public void free() {
		this.free = true;
	}
	public String getSpotId() {
		return this.spotId;
	}
}
class ElectricSpot extends ParkingSpot{
	private String Type,spotId;
	private boolean free;
	ElectricSpot(String Id){
		Type = "Electric";
		free = true;
		spotId = Id;
	}
	public String getType() {
		return Type;
	}
	public boolean isFree() {
		return free;
	}
	public void assign() {
		free = false;
	}
	public void free() {
		this.free = true;	
	}
	public String getSpotId() {
		return this.spotId;
	}
}