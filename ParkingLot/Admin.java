import java.util.ArrayList;
// The class which manages all the payments, assigning and clearing tasks
// 
import java.util.Scanner;
class Admin {
	static public ArrayList<ParkTicket> Tickets = new ArrayList<ParkTicket>();// List of all Tickets which are Active
	static public void getParkTicket(Customer C,Vehicle V) {
		if(ParkingLot.available(V)) {
			ParkTicket pt = new ParkTicket(C,V,C.getCustomerId()+V.getVehicleId());
			ParkingLot.assign(pt);
			Tickets.add(pt);
			C.Tickets.add(pt);
			System.out.println("Successfully Parked! at "+pt.getFloorId()+" "+pt.getSpotId());
		}
		else {
			System.out.println("No space!!!");
		}
	}
	
	static public void setTicketStatus(ParkTicket pt) {
		pt.setStatus();
	}
	
	static public void ExitPoint(ParkTicket t) {
		Scanner sc = new Scanner(System.in);
		System.out.println("You are at the ExitPoint!!\nChoose:");
		System.out.println("1.AutoPay\n2.PayToAttendant");
		int option = sc.nextInt();
		if(option == 1) {
			CreditCardPayment ccp = new CreditCardPayment();
			ccp.Pay(t);
		}
		else {
			CashPayment cp = new CashPayment();
			cp.Pay(t);
		}
		sc.close();
	}
	// When a customer tries to exit this function is called.
	static public void exit(Customer C,ParkTicket t) {
		if(Tickets.contains(t)) {
			if(t.getstatus()) {
				ExitPoint(t);
			}
			System.out.println("Thank You!!");
			ParkingLot.clear(t);
			C.Tickets.remove(t);
			Tickets.remove(t);
		}
		else {
			System.out.println("No Ticket Found!!");
		}
	}
	// Displays The currently available spots on each floor
	static public void getAvailableSpots() {
		ParkingLot.DisplayAvailableSpots();
	}
	
}
