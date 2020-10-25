import java.util.*;
// Displays Info and Provides an option to pay 
public class CustomerInfoPanel {
	private ArrayList<ParkTicket> Tickets;
	private ArrayList<Vehicle> Vehicles;
	CustomerInfoPanel(ArrayList<ParkTicket> Tickets,ArrayList<Vehicle>Vehicles){
		this.Tickets = Tickets;
		this.Vehicles = Vehicles;
	}
	 public void display() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.CustomerInfo\n2.PayForaTicket(TicketID is required)");
		int option = sc.nextInt();
		switch(option) {
			case 1:{
				int cnt=1;
				for(Vehicle V : Vehicles) {
					System.out.println(cnt+". VehicleType:"+V.getType()+" VehicleId:"+V.getVehicleId());
					cnt++;
				}
				break;
			}
			case 2:	{
				System.out.println("Please enter TicketID");
				String TicketId = sc.next();
				for(ParkTicket pt:Tickets) {
					if(pt.getTicketId() == TicketId) {
						Pay(pt);
						break;
					}
				}
			}
		}
		sc.close();
	}
	public void Pay(ParkTicket pt) {
		CreditCardPayment CC = new CreditCardPayment();
		CC.Pay(pt);
	}
}
