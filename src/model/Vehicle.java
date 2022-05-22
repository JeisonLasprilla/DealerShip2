package model;
import java.util.*;

public abstract class Vehicle{

	public static final int MAX_DOCUMENTS = 3;  

	public Document[] documents;
	protected String id;
	protected double basePrice;
	protected String brand;
	protected int model;
	protected double cc;
	protected double km;
	protected String licensePlate;
	protected Status status;

	public Vehicle(String id, double basePrice, String brand, int model, double cc, double km, String licensePlate, String status){ 
		documents = new Document [MAX_DOCUMENTS];
		this.id = id;
		this.basePrice = basePrice;
		this.brand = brand;
		this.model = model;
		this.cc = cc;
		this.km = km;
		this.licensePlate = licensePlate;

		if (status.equals("1")){
			this.status = Status.NEW;
		} else if (status.equals("2")){
			this.status = Status.USED;
		}
	}

	public abstract double calculatePrice();
}