package model;
import java.util.*;

public class DealerShip{

	private ArrayList <Vehicle> vehicles;
	private Parking parkingA;
	
	public DealerShip(ArrayList <Vehicle> vehicles){
		this.vehicles = vehicles; //solo pra el init(tampoco los parametros)
		parkingA = new Parking();
		//vehicles = new ArrayList <Vehicle>();
	}

	public void addElectricCar(String id, double basePrice, String brand, int model, double cc, double km, String licensePlate, String status, int doorsNumber, boolean polarized, String carType, double batteryLife, double kWForKm, String chargeType, double priceSOAT, int yearSOAT, double coverageAmount, double priceReview, int yearReview, double gasReleased, double priceCard, int yearCard){
		vehicles.add(new Electric(id, basePrice, brand, model, cc, km, licensePlate, status, doorsNumber, polarized, carType, batteryLife, kWForKm, chargeType)); 
		addDocuments(id, priceSOAT, yearSOAT, coverageAmount, priceReview, yearReview, gasReleased, priceCard, yearCard);
	}

	public void addFuelCar(String id, double basePrice, String brand, int model, double cc, double km, String licensePlate, String status, int doorsNumber, boolean polarized, String carType, double gallonsCapacity, double gallonsForKm, String fuelType, double priceSOAT, int yearSOAT, double coverageAmount, double priceReview, int yearReview, double gasReleased, double priceCard, int yearCard){
		vehicles.add(new Fuel(id, basePrice, brand, model, cc, km, licensePlate, status, doorsNumber, polarized, carType, gallonsCapacity, gallonsForKm, fuelType)); 
		addDocuments(id, priceSOAT, yearSOAT, coverageAmount, priceReview, yearReview, gasReleased, priceCard, yearCard);
	}

	public void addHybridCar(String id, double basePrice, String brand, int model, double cc, double km, String licensePlate, String status, int doorsNumber, boolean polarized, String carType, double batteryLife, double kWForKm, String chargeType, double gallonsCapacity, double gallonsForKm, String fuelType, double priceSOAT, int yearSOAT, double coverageAmount, double priceReview, int yearReview, double gasReleased, double priceCard, int yearCard){
		vehicles.add(new Hybrid(id, basePrice, brand, model, cc, km, licensePlate, status, doorsNumber, polarized, carType, batteryLife, kWForKm, chargeType, gallonsCapacity, gallonsForKm, fuelType)); 
		addDocuments(id, priceSOAT, yearSOAT, coverageAmount, priceReview, yearReview, gasReleased, priceCard, yearCard);
	}

	public void addMotorcicle(String id, double basePrice, String brand, int model, double cc, double km, String licensePlate, String status, double gallonsCapacity, double gallonsForKm, String motorcicleType, double priceSOAT, int yearSOAT, double coverageAmount, double priceReview, int yearReview, double gasReleased, double priceCard, int yearCard){
		vehicles.add(new Motorcicle(id, basePrice, brand, model, cc, km, licensePlate, status, gallonsCapacity, gallonsForKm, motorcicleType)); 
		addDocuments(id, priceSOAT, yearSOAT, coverageAmount, priceReview, yearReview, gasReleased, priceCard, yearCard);
	}


	public void addDocuments(String id, double priceSOAT, int yearSOAT, double coverageAmount, double priceReview, int yearReview, double gasReleased, double priceCard, int yearCard){
		
		int L = 4;
		for (int i = 0; i < vehicles.size(); i++){


			if (vehicles.get(i).id.equals(id)){
				if (priceSOAT != -1 || yearSOAT != -1 || coverageAmount != -1){
					vehicles.get(i).documents[0] = new SOAT (priceSOAT, yearSOAT, coverageAmount);// soat
				}

				if (priceReview != -1 || yearReview != -1 || gasReleased != -1){
					vehicles.get(i).documents[1] = new Review (priceReview, yearReview, gasReleased);// revisión	
				}
				
				if (priceCard != -1 && yearCard != -1){
					vehicles.get(i).documents[2] = new OwnershipCard (priceCard, yearCard);
				}

				for (int r = 0; r < L; r++){
					for (int c = 0; c < L; c++){

						 int a = (int)(Math.random()*(100-1+1)+1);
						 if(vehicles.get(i).documents[0] != null){
						 	vehicles.get(i).documents[0].picture[r][c] = a;
						 }

						 if(vehicles.get(i).documents[1] != null){
						 	vehicles.get(i).documents[1].picture[r][c] = a;
						 }

						 if(vehicles.get(i).documents[2] != null){
						 	vehicles.get(i).documents[2].picture[r][c] = a;
						 }
					}
				}
			}
		}
	}

	public double calculateTotalPrice(String searchID, double additional){

		double totalPrice = 0;
		for (int i = 0; i < vehicles.size(); i++){

			if(vehicles.get(i).id.equals(searchID)){
				//For vehicle
				totalPrice = vehicles.get(i).calculatePrice();

				//Car used
				if (vehicles.get(i) instanceof Car && vehicles.get(i).status.equals("USED")){
					totalPrice = totalPrice - (vehicles.get(i).basePrice * 0.10); //-10%
				} else if (vehicles.get(i).documents[0] == null && vehicles.get(i).documents[1] == null){
					totalPrice = totalPrice + 500000;
				} else {
					totalPrice = totalPrice + additional;
				}
			}
		}

		if (totalPrice == 0){
			System.out.println("ERROR\n ID does not match any vehicle");
		}

		return totalPrice;
	}

	public void printForVType(String vType){

		switch (vType){
			case "1": //print cars
					for (int i = 0; i < vehicles.size(); i++){

						if (vehicles.get(i) instanceof Car){
							System.out.println(vehicles.get(i).toString());
						}
					}
			break;

			case "2": //print motorcicles
					for (int i = 0; i < vehicles.size(); i++){

						if (vehicles.get(i) instanceof Motorcicle){
							System.out.println(vehicles.get(i).toString());
						}

					}
			break;
		}	
	}
	
	public void printForFType(String fType){

		
		switch (fType){
					case "1": //print charge
							for (int i = 0; i < vehicles.size(); i++){

								if (vehicles.get(i) instanceof Electric){
									System.out.println(vehicles.get(i).toString());
								}
							}
					break;

					case "2": //print fuel
							for (int i = 0; i < vehicles.size(); i++){

								if (vehicles.get(i) instanceof Motorcicle || vehicles.get(i) instanceof Fuel){
									System.out.println(vehicles.get(i).toString());
								}

							}
					break;

					case "3": //print charge and fuel
							for (int i = 0; i < vehicles.size(); i++){

								if (vehicles.get(i) instanceof Hybrid){
									System.out.println(vehicles.get(i).toString());
								}

							}
					break;

		}
	}

	public void printForSt(String st){
		switch (st){
			case "1": //print new vehicles
					for (int i = 0; i < vehicles.size(); i++){

						if (vehicles.get(i).status.equals(Status.NEW)){
							System.out.println(vehicles.get(i).toString());
						}
					}
			break;

			case "2": //print used vehicles
					for (int i = 0; i < vehicles.size(); i++){

						if (vehicles.get(i).status.equals(Status.USED)){
							System.out.println(vehicles.get(i).toString());
						}
					}
			break;
		}
	}

	public String decodeSOAT(String typedID){

		boolean matches = false;
		String document = "";

		for (int i = 0; i < vehicles.size(); i++){
			if (vehicles.get(i).id.equals(typedID)){
				matches = true;
				if(vehicles.get(i).documents[0] != null){
					document = vehicles.get(i).documents[0].decodeDocument();
				} else{
					document = "The vehicle does not have SOAT";
				}
			}
		}

		if(matches == false){
			System.out.println("The typed ID does not match with any vehicle");
		}

		return document;
	}

	public String decodeReview(String typedID){

		boolean matches = false;
		String document = "";

		for (int i = 0; i < vehicles.size(); i++){
			if (vehicles.get(i).id.equals(typedID)){
				matches = true;
				if(vehicles.get(i).documents[1] != null){
					document = vehicles.get(i).documents[1].decodeDocument();
				} else{
					document = "The vehicle does not have Review";
				}
			}
		}

		if(matches == false){
			System.out.println("The typed ID does not match with any vehicle");
		}
		
		return document;
	}

	public String decodeOwnershipCard(String typedID){

		boolean matches = false;
		String document = "";

		for (int i = 0; i < vehicles.size(); i++){
			if (vehicles.get(i).id.equals(typedID)){
				matches = true;
				if(vehicles.get(i).documents[2] != null){
					document = vehicles.get(i).documents[2].decodeDocument();
				} else{
					document = "The vehicle does not have Ownership Card";
				}
			}
		}

		if(matches == false){
			System.out.println("The typed ID does not match with any vehicle");
		}
		
		return document;
	}


	public void callShowParking(){

		//Reset 2 the map
		parkingA.resetMatrix();

		//Set values 2 cars matrix
		updateParkingCars();

		parkingA.showParking();
	}

	public void updateParkingCars(){
		for(int i = 0; i < vehicles.size(); i++){

			if(vehicles.get(i) instanceof Car && vehicles.get(i).status.equals(Status.USED) && vehicles.get(i).model < 2015){
				if(parkingA.parkingCarsHasSpace() == true){

					if (vehicles.get(i).model == 2014){

						parkingA.parkingCars[parkingA.emptyI(0)][0] = vehicles.get(i);

					} else if (vehicles.get(i).model == 2013){

						parkingA.parkingCars[parkingA.emptyI(1)][1] = vehicles.get(i);

					} else if (vehicles.get(i).model == 2012){

						parkingA.parkingCars[parkingA.emptyI(2)][2] = vehicles.get(i);

					} else if (vehicles.get(i).model == 2011){

						parkingA.parkingCars[parkingA.emptyI(3)][3] = vehicles.get(i);

					} else if (vehicles.get(i).model < 2011){

						parkingA.parkingCars[parkingA.emptyI(4)][4] = vehicles.get(i);
					}

				} else{
					System.out.println("There are Cars outside the parking");
				}
			}
		}
	}

	public void reset(){
		parkingA.resetMatrix();
	}

	public String percentage(){
		return "\nOccupancy: "+parkingA.calculatePercentage()+"%";
	}

	public void forYears(int minorYear, int majorYear){
		parkingA.printForYears(minorYear, majorYear);
	}

	public void newerAndOlder(){
		
		System.out.println("The newer car is:\n");
		System.out.println(parkingA.newerCar());

		System.out.println("The older car is:\n");
		System.out.println(parkingA.olderCar());
	}

}