package model;
import java.util.*;

public abstract class Car extends Vehicle {

	protected int doorsNumber;
	protected boolean polarized;
	protected CarType carType;

	public Car(String id, double basePrice, String brand, int model, double cc, double km, String licensePlate, String status, int doorsNumber, boolean polarized, String carType){

		super(id, basePrice, brand, model, cc, km, licensePlate, status);
		this.doorsNumber = doorsNumber;
		this.polarized = polarized;
		
		if (carType.equals("1")){
			this.carType = CarType.PICKUP;
		} else if (carType.equals("2")){
			this.carType = CarType.SEDAN;
		}

	}
}