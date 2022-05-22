package model;
import java.util.*;

public class Motorcicle extends Vehicle implements FuelConsumption{

	private double gallonsCapacity;
	private double gallonsForKm;
	private MotorcicleType motorcicleType;

	public Motorcicle(String id, double basePrice, String brand, int model, double cc, double km, String licensePlate, String status, double gallonsCapacity, double gallonsForKm, String motorcicleType){

		super(id, basePrice, brand, model, cc, km, licensePlate, status);
		this.gallonsCapacity = gallonsCapacity;
		this.gallonsForKm = gallonsForKm;

		if(motorcicleType.equals("1")){
			this.motorcicleType = MotorcicleType.STANDARD;
		} else if (motorcicleType.equals("2")){
			this.motorcicleType = MotorcicleType.SPORT;
		} else if (motorcicleType.equals("3")){
			this.motorcicleType = MotorcicleType.SCOOTER;
		} else if (motorcicleType.equals("4")){
			this.motorcicleType = MotorcicleType.CROOS;
		}
	}

	@Override
	public String toString(){

		return ("\n\tMotorcicle\n"+
				"\nID: "+id+""+
				"\nBase price: "+basePrice+""+
				"\nBrand: "+brand+""+
				"\nModel: "+model+""+
				"\nCC: "+cc+""+
				"\nKm: "+km+""+
				"\nLicense plate: "+licensePlate+""+
				"\nStatus: "+status+""+
				"\nGallons Capacity: "+gallonsCapacity+""+
				"\nGallons/Km: "+gallonsForKm+""+
				"\nMotorcicle type: "+motorcicleType+""+
				"\nComsumption: "+calculateFuelConsumption()+""
				);

	}

	@Override
	public double calculatePrice(){
		double price = basePrice + (basePrice * 0.04); //+0.4%
		if (status.equals("USED")){
			price = price - (basePrice * 0.02);
		}
		return price;
	}

	@Override
	public double calculateFuelConsumption(){
		double totalComsuption = 0;

		totalComsuption = gallonsCapacity * (cc / 75);

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

}