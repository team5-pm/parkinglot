import java.util.*;
// The Main Class which contains Floors 
class ParkingLot {
	private static int NumberofFloors; // Number of Floors in the Lot
	private static ArrayList<Floor> Floors; // The Array Storing all the Floors
	private static int TotalSize; // The Size(Capacity) of the ParkingLot
	private static int curSize; // Spots Currently Occupied
	static public void setFloorsandSize(int numoffloors,int Size) {
		NumberofFloors = numoffloors;
		TotalSize = Size;
	}
	
	static public void build(int Cspot,int Espot,int Mspot,int Hspot,int Lspot) {
		Floors = new ArrayList<Floor>();
		for(int i=0;i<NumberofFloors;i++) {
			String floorId = (i+"");
			ArrayList<ParkingSpot> l = new ArrayList<ParkingSpot>();
			for(int j = 0;j<Espot;j++) {
				ElectricSpot E = new ElectricSpot(floorId+j);
				l.add(E);
			}
			for(int j = 0;j<Lspot;j++) {
				LargeSpot L = new LargeSpot(floorId+j);
				l.add(L);
			}
			for(int j = 0;j<Mspot;j++) {
				MotorcycleSpot M = new MotorcycleSpot(floorId+(j+5));
				l.add(M);
			}
			for(int j = 0;j<Hspot;j++) {
				HandicappedSpot H = new HandicappedSpot(floorId+(j+10));
				l.add(H);
			}
			for(int j=0;j<Cspot;j++) {
				CompactSpot C = new CompactSpot(floorId+(j+15));
				l.add(C);
			}
			Floors.add(new Floor(floorId,l));
			
		}
	}
	static public boolean available(Vehicle V) {
		if(curSize >= TotalSize) {
			return false;
		}
		for(Floor f:Floors) {
			if(f.getAvailableSpots(V.getType()) > 0) {
				 return true;
			}
		}
		return false;
	}
	static public void assign(ParkTicket pt) {
		for(Floor f:Floors) {
			if(f.getAvailableSpots(pt.getVehicleType()) > 0) {
				ParkingSpot ps = f.getSpot(pt.getVehicleType());
				pt.setFloorId(f.getfloorId());
				pt.setSpotId(ps.getSpotId());
				curSize++;
				break;
			}
		}
	}
	static public void clear(ParkTicket pt) {
		for(Floor f:Floors) {
			if(pt.getFloorId() == f.getfloorId()) {
				f.clear(pt.getSpotId());
				curSize--;
				break;
			}
		}
	}
	static public void DisplayAvailableSpots() {
		int cnt = 1;
		//Compact, Large, Handicapped, Motorcycle
		for(Floor f: Floors) {
			System.out.println("Floor :"+cnt);
			System.out.print("Compact "+f.getAvailableSpots("Compact")+" ");
			System.out.print("Large "+f.getAvailableSpots("Large")+" ");
			System.out.print("Handicapped "+f.getAvailableSpots("Handicapped")+" ");
			System.out.print("Motorcycle "+f.getAvailableSpots("Motorcycle")+" ");
			System.out.println();
			cnt++;
		}
	}
	static public void DisplayAvailableSpots(int floor) {
		for(Floor f: Floors) {
			String flr = floor+"";
			if(f.getfloorId().equals(flr)) {
				f.DisplayAvailableSpots();
			}
		}
	}
}
