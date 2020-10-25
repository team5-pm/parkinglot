/// Vehicle interface
/// Van,Truck,Car,Handicapped,Motorcycle,Electric implement Vehicle interface

abstract class Vehicle {
	abstract public String getType(); // Get the type of the Vehicle
	abstract public String getVehicleId(); // Get the ID of the Vehicle 
}

class Van extends Vehicle {
    private String vehicleId;
    private String Type;
    public Van(String vehicleId) {
        this.vehicleId = vehicleId;
        this.Type = "Large";
    }
    public String getVehicleId() {
        return vehicleId;
    }
    public String getType() {
        return Type;
    }
}

class Truck extends Vehicle {
    private String vehicleId;
    private String Type;
    public Truck(String vehicleId) {
        this.vehicleId = vehicleId;
        this.Type = "Large";
    }
    public String getVehicleId() {
        return vehicleId;
    }
    public String getType() {
        return Type;
    }
}

class Car extends Vehicle {
	private String vehicleId;
	private String Type;
    public Car(String vehicleId) {
        this.vehicleId = vehicleId;
        this.Type = "Compact";
    }
    public String getVehicleId() {
        return vehicleId;
    }

    public String getType() {
        return Type;
    }

}

class Motorcycle extends Vehicle {
    private String vehicleId;
    private String Type;
    public Motorcycle(String vehicleId) {
        this.vehicleId = vehicleId;
        Type = "Motorcycle";
    }
     public String getVehicleId() {
        return vehicleId;
    }
   public String getType() {
        return Type;
    }
}

class Handicapped extends Vehicle{
	private String vehicleId;
	private String Type;
	public Handicapped(String vehicleId) {
		this.vehicleId = vehicleId;
		Type = "Handicapped";
	}
	public String getType() {
		return Type;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	
}
class Electric extends Vehicle{
	private String vehicleId;
	private String Type;
	public Electric(String vehicleId) {
		this.vehicleId = vehicleId;
		Type = "Electric";
	}
	public String getType() {
		return Type;
	}
	public String getVehicleId() {
		return vehicleId;
	}
}