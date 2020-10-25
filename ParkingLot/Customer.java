import java.util.ArrayList;
// Stores all info about customer his/her vehicles and Tickets.
// Provides some functionality in terms of payment, charging and info
class Customer {
	private String CustomerId;
	public ArrayList<ParkTicket> Tickets;
	public ArrayList<Vehicle> Vehicles;
	private boolean onCharge=false;
	Customer(String CustomerId,Vehicle V){
		Tickets = new ArrayList<ParkTicket>();
		Vehicles = new ArrayList<Vehicle>();
		this.CustomerId = CustomerId;
		getParkTicket(V);
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public void getParkTicket(Vehicle V) {
		if(!Vehicles.contains(V)) {
			Admin.getParkTicket(this,V);
			Vehicles.add(V);
		}
		else{
			System.out.println("Wrong Info!");
		}
	}
	public void getVehicleIds() {
		for(Vehicle V:Vehicles) {
			System.out.println(V.getType() +" : " +V.getVehicleId());
		}
	}
	public void exit(String VehicleId) {
		for(ParkTicket t:Tickets) {
			if(t.getVehicleId() == VehicleId) {
				Admin.exit(this,t);
				break;
			}
		}
		for(Vehicle V: Vehicles) {
			if(V.getVehicleId() == VehicleId) {
				Vehicles.remove(V);
				break;
			}
		}
	}
	public void Charge(String VehicleId) {
		boolean action = false;
		for(ParkTicket pt : Tickets) {
			if(pt.getTicketId().equals(VehicleId) && pt.getVehicleType().equals("Electric")) {
				action = true;
				if(onCharge) {
					System.out.println("Unplugged!!!");
					onCharge = false;
				}
				else {
					System.out.println("Charging!!");
					onCharge = true;
				}
			}
		}
		if(!action)
			System.out.println("Invalid Info");
	}
	public void PayAtElectricPanel(String VehicleId) {
		boolean action = false;
		for(ParkTicket pt : Tickets) {
			if(pt.getTicketId() == VehicleId && pt.getVehicleType()=="Electric")
				action = true;
				CreditCardPayment cc = new CreditCardPayment();
				cc.Pay(pt);
			}
		if(!action){
			System.out.println("Invalid Info");
		}
	}
	public void CustomerInfoPanel() {
		CustomerInfoPanel cip = new CustomerInfoPanel(Tickets,Vehicles);
		cip.display();
	}
}
