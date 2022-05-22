package model;
import java.util.*;

public class Electric extends Car implements BatteryConsumption {

	private double batteryLife;
	private double kWForKm;
	private ChargeType chargeType;

	public Electric(String id, double basePrice, String brand, int model, double cc, double km, String licensePlate, String status, int doorsNumber, boolean polarized, String carType, double batteryLife, double kWForKm, String chargeType){

		super(id, basePrice, brand, model, cc, km, licensePlate, status, doorsNumber, polarized, carType);
		this.batteryLife = batteryLife;
		this.kWForKm = kWForKm;

		if (chargeType.equals("1")){
			this.chargeType = ChargeType.FASTCHARGE;
		} else if (chargeType.equals("2")){
			this.chargeType = ChargeType.REGULARCHARGE;
		}


	}

	@Override
	public String toString(){

		return ("\n\tElectric Car\n"+
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
				"\nBattery life: "+batteryLife+""+
				"\nkW/Km: "+kWForKm+""+
				"\nCharge type: "+chargeType+"\n"+
				"\nBattery comsumption: "+calculateBatteryComsuption()+""
				);
	}

	@Override
	public double calculatePrice(){
		double price = basePrice + (basePrice*0.20);
		return price;
	}

	@Override
	public double calculateBatteryComsuption(){


		double totalComsuption = 0;
		
		if (chargeType.equals(ChargeType.FASTCHARGE)){
			totalComsuption =(batteryLife + 13) * (cc / 100);
		} else if (chargeType.equals(ChargeType.REGULARCHARGE)){
			totalComsuption = (batteryLife + 18) * (cc / 100);
		}

		return totalComsuption;
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


}