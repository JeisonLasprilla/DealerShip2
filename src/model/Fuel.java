package model;
import java.util.*;

public class Fuel extends Car implements FuelConsumption{

	private double gallonsCapacity;
	private double gallonsForKm;
	protected FuelType fuelType;
	
	public Fuel(String id, double basePrice, String brand, int model, double cc, double km, String licensePlate, String status, int doorsNumber, boolean polarized, String carType, double gallonsCapacity, double gallonsForKm, String fuelType){

		super (id, basePrice, brand, model, cc, km, licensePlate, status, doorsNumber, polarized, carType);
		this.gallonsCapacity = gallonsCapacity;
		this.gallonsForKm = gallonsForKm;

		if (fuelType.equals("1")){
			this.fuelType = FuelType.PREMIUM;
		} else if (fuelType.equals("2")){
			this.fuelType = FuelType.REGULAR;
		} else if (fuelType.equals("3")){
			this.fuelType = FuelType.DIESEL;
		}

	}

	@Override
	public String toString(){

		return ("\n\tFuel Car\n"+
				"\nID: "+id+""+
				"\nBase price: "+basePrice+""+
				"\nBrand: "+brand+""+
				"\nModel: "+model+""+
				"\nCC: "+cc+""+
				"\nKm: "+km+""+
				"\nLicense plate: "+licensePlate+""+
				"\nStatus: "+status+""+
				"\nNumber of doors: "+doorsNumber+""+
				"\nPolarized: "+basePrice+""+
				"\nCar type: "+carType+""+
				"\nGallons Capacity: "+gallonsCapacity+""+
				"\nGallons/Km: "+gallonsForKm+""+
				"\nFuel type: "+fuelType+"\n"+
				"\nComsumption: "+calculateFuelConsumption()+""
				);

	}

	@Override
	public double calculatePrice(){
		double price = basePrice;
		return price;
	}

	@Override
	public double calculateFuelConsumption(){
		double totalComsuption = 0;

		totalComsuption = gallonsCapacity * (cc / 150);

		return totalComsuption;
	}

	public double getGallonsCapacity(){
		return gallonsCapacity;
	}

	public void setGallonsCapacity(){
		this.gallonsCapacity = gallonsCapacity;
	}

	public double getGallonsForKm(){
		return gallonsForKm;
	}

	public void setGallonsForKm(){
		this.gallonsForKm = gallonsForKm;
	}

	// public FuelType getFuelType() {
 //        return fuelType;
 //    }

 //    public void setFuelType(FuelType fuelType) {
 //        this.fuelType = fuelType;
 //    }

}