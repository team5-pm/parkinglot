// Encapsulation : Hiding data from the user and using getter functions
// The class which binds all other classes together which links the customer to the vehicles, assists Admin.
// TIME class is used for getting the elapsed time of parking
public class ParkTicket {
	 private String customerId,vehicleType,vehicleId,ticketId; // Customer and Vehicle Details
	 private long parkTime; // The Time at which Ticket was printed
	 private String floorId,spotId; // The ParkingSpot Details
	 private boolean status; // The validity of the Ticket
	 ParkTicket(Customer C,Vehicle V,String ticketId){
		 this.customerId = C.getCustomerId();
		 this.vehicleId = V.getVehicleId();
		 this.vehicleType = V.getType();
		 this.ticketId = ticketId;
		 this.parkTime = System.currentTimeMillis(); // Time at which the Vehicle was parked
		 status = true;
	 }
	 public String getTicketId() {
		 return ticketId;
	 }
	 public boolean getstatus() {
		 return status;
	 }
	 public String getCustomerId() {
		 return	customerId; 
	 }
	 public String getVehicleType() {
		 return	vehicleType; 
	 }
	 public String getVehicleId() {
		 return	vehicleId; 
	 }
	 public int getParkTime() {
		 long end = System.currentTimeMillis(); // Time of Exit or Payment
		 float msec =end - parkTime;
		 float sec = msec/1000F;
		 float minutes = sec/60F;
		 int timeElapsed = (int)minutes;
		 return timeElapsed;
	 }
	 public String getFloorId() {
		 return	floorId; 
	 }
	 public String getSpotId() {
		 return	spotId; 
	 }	  
	 public void setStatus() {
		 this.status = false;
	 }
	 public void setFloorId(String floorId) {
		 this.floorId = floorId;
	 }
	 public void setSpotId(String spotId) {
		 this.spotId = spotId;
	 }
}
