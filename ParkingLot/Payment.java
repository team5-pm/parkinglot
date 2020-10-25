import java.util.*;
// Has implementation for CreditCard and Cash Payments which can be readily used
// getFee function can be defined as per requirements
// Pay function is implemented according to the payment type	 
abstract class Payment {
	public double getFee(int time){
		double fee = 0.0;
		if(time <= 60){
			fee = 20; 
		}
	    else if(time > 60 && time <= 120){
	    	fee = 30;
	    }
	    else if(time > 120 && time <= 180) {
	    	fee = 40;
 		}
	    else{
	    	fee = (40.0 +Math.ceil(( time - 180 )/60)*5.0);
	    }
		
		return fee;
	}
	public abstract void Pay(ParkTicket pt);
}

class CreditCardPayment extends Payment{
	public void Pay(ParkTicket pt) {
		Scanner sc = new Scanner(System.in);
		if(pt.getstatus()) {
		System.out.println("Enter Card Number:");
		String num = sc.next();
		System.out.println("The entered Card Number " + num.charAt(0) + "*********");
		System.out. println("Paying " +getFee(pt.getParkTime())+ " rupees using debit card" );
		Admin.setTicketStatus(pt);
		}
		else {
			System.out.println("Already Paid!");
		}
		sc.close();
	}
}
class CashPayment extends Payment{
	public void Pay(ParkTicket pt) {
		if(pt.getstatus()) {
			System.out. println("Paying " +getFee(pt.getParkTime())+ " rupees via cash to the Attendant" );
			Admin.setTicketStatus(pt);
		}
		else{
			System.out.println("Already Paid!");
		}
	}
}