package model;
import java.util.*;

public class Hybrid extends Car implements BatteryConsumption, FuelConsumption {

	private double gallonsCapacity;
	private double gallonsForKm;
	private double batteryLife;
	private double kWForKm;
	private ChargeType chargeType;
	protected FuelType fuelType;

	public Hybrid(String id, double basePrice, String brand, int model, double cc, double km, String licensePlate, String status, int doorsNumber, boolean polarized, String carType, double batteryLife, double kWForKm, String chargeType, double gallonsCapacity, double gallonsForKm, String fuelType){

		super (id, basePrice, brand, model, cc, km, licensePlate, status, doorsNumber, polarized, carType);
		this.gallonsCapacity = gallonsCapacity;
		this.kWForKm = kWForKm;
		this.batteryLife = batteryLife;
		this.gallonsForKm = gallonsForKm;

		if (chargeType.equals("1")){
			this.chargeType = ChargeType.FASTCHARGE;
		} else if (chargeType.equals("2")){
			this.chargeType = ChargeType.REGULARCHARGE;
		}

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

		return ("\n\tHybrid Car\n"+
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
				"\nFuel type: "+fuelType+""+
				"\nBattery life: "+batteryLife+""+
				"\nkW/Km: "+kWForKm+""+
				"\nCharge type: "+chargeType+"\n"+
				"\nFuel comsumption: "+calculateFuelConsumption()+""+
				"\nBattery comsumption: "+calculateBatteryComsuption()+""
				);

	}


	@Override
	public double calculatePrice(){
		double price = basePrice + (basePrice*0.15);
		return price;
	}

	@Override
	public double calculateFuelConsumption(){
	
		double totalComsuption = 0;

		totalComsuption = gallonsCapacity * (cc / 180);

		return totalComsuption;
	}

	@Override
	public double calculateBatteryComsuption(){
		double totalComsuption = 0;
		
		if (chargeType.equals(ChargeType.FASTCHARGE)){
			totalComsuption = batteryLife * (cc / 200);
		} else if (chargeType.equals(ChargeType.REGULARCHARGE)){
			totalComsuption = (batteryLife + 7) * (cc / 200);
		}
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

	public double getBatteryLife(){
		return batteryLife;
	}

	public void setBatteryLife(){
		this.batteryLife = batteryLife;
	}

	public double getkWForKm(){
		return kWForKm;
	}

	public void setkWForKm(){
		this.kWForKm = kWForKm;
	}

    public ChargeType getChargeType() {
        return chargeType;
    }

    public void setChargeType(ChargeType chargeType) {
        this.chargeType = chargeType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }


}