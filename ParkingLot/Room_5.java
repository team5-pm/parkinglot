import java.util.*;
// The class which sets up everything.
public class Room_5 {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		ParkingLot.setFloorsandSize(5, 50); //Number of floors and TotalSize of the Parkinglot 
		ArrayList<Customer> Customers = new ArrayList<Customer>();
		ParkingLot.build(5,5,5,5,5); // Initializing number of different types of spots on each floor
		int option = 1;
		boolean con = true;
		while(con) {
			System.out.println("1. NewCustomer");
			System.out.println("2. AlreadyHere!");
			if(sc.hasNextInt())option = sc.nextInt();
			if(option == 1) {
				String VehicleId,Name;
				System.out.println("Please Enter the Details");
				System.out.println("Name:");
				Name = sc.next();
				System.out.println("VehicleId:");
				VehicleId = sc.next();
				System.out.println("VehicleType:\n1.Truck\n2.Motorcycle\n3.Van\n4.Handicapped\n5.Electric");
				Vehicle V;
				int option2 = sc.nextInt();
				switch(option2) {
					case 1:{
						V = new Truck(VehicleId);
						break;
					}
					case 2:{
						V = new Motorcycle(VehicleId);
						break;
					}
					case 3:{
						V = new Van(VehicleId);
						break;
					}
					case 4:{
						V = new Handicapped(VehicleId);
						break;
					}
					default :{
						V = new Electric(VehicleId);
						break;
					}
				}
				System.out.println(V.getType());
				if(!ParkingLot.available(V)) {
					System.out.println("No Space");
				}
				else {
					Customer C = new Customer(Name,V);
					Customers.add(C);
				}	
			}
			Options(Customers);
			System.out.println("Continue?[Y/N]");
			char choice = sc.next().charAt(0);
			if(choice == 'N') {
				break;
			}
			System.out.println();
		}
	}
	static void Options(ArrayList<Customer> Customers) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Display Spots");
		System.out.println("2.Customer Options");
		System.out.println("3.Exit");
		int option = sc.nextInt();
		if(option == 1) {
			System.out.println("1.Entire ParkingLot\n2.Specific Floor");
			int option2 = sc.nextInt();
			if(option2 == 1) {
				ParkingLot.DisplayAvailableSpots();
			}
			else {
				System.out.println("Floor:");
				ParkingLot.DisplayAvailableSpots(sc.nextInt());
			}
		}
		else if(option==2){
			System.out.println("Enter CustomerId(Name):");
			String Name = sc.next();
			boolean contains = false;
			Customer Cur = null;
			for(Customer c:Customers) {
				if(c.getCustomerId().equals(Name)) {
					contains = true;
					Cur = c;
					break;
				}
			}
			if(contains) {
				System.out.println("1. CustomerInfoPanel");
				System.out.println("2. Charge Vehicle:");
				System.out.println("3. Pay through e-Panel:");
				System.out.println("4. Exit Vehicle:");
				System.out.println("5. End");
				int op = sc.nextInt();
				switch(op) {
					case 1:{
						Cur.CustomerInfoPanel();
						break;
					}
					case 2:{
						System.out.println("Enter Valid VehicleId:");
						String VehicleId = sc.next();
						Cur.Charge(VehicleId);
						break;
					}
					case 3:{
						System.out.println("Enter Valid VehicleId:");
						String VehicleId = sc.next();
						Cur.PayAtElectricPanel(VehicleId);
						break;
					}
					case 4:{
						System.out.println("Enter Valid VehicleId:");
						String VehicleId = sc.next();
						Cur.exit(VehicleId);
						break;
					}
					default:{
						break;
					}
				}
			}
			else {
				System.out.println("Invalid Info!!");
			}
		}
		else System.out.println("Invalid Input");
	}
	
}  




