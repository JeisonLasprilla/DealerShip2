package ui; //Paquete
import java.util.*; //Scanner
import model.DealerShip;

public class Main{

	private DealerShip a;

	static Scanner sc = new Scanner(System.in); // sc

	public Main(){
		//a = new DealerShip();
		InitModel init = new InitModel();
		a = new DealerShip(init.createVehicles()); //Solo para el init
	}

	public static void main (String[] args){

		Main mainDealerShip= new Main();

		String option = "0";
		
		do{
			option = mainDealerShip.showMenu();
			mainDealerShip.executeOperation(option);
			
		}while (!option.equals("0"));
	}

	public String showMenu(){
		System.out.println( "\n(1) Register vehicle"+
							"\n(2) Calculate sale price"+
							"\n(3) Show information vehicles"+
							"\n(4) Show documents"+
							"\n(5) Show parking"+
							"\n(6) Information parking"+
							"\n(0) Exit\n"
							);
		String option = sc.nextLine();
		return option;
	}

	public void executeOperation(String option) {
		
		switch(option) {

		case "1":
			createVehicle();

		break;
		
		case "2":
			price();
		break;

		case "3":
			searchVehicle();
		break;

		case "4":
			showDocuments();
		break;

		case "5":
			printParking();
		break;

		case "6":
			infoParking();
		break;	

		case "7":
			setDocuments2Test();
		break;	

		case "0":
			System.out.println("Bye!");
		break;

		default:
			System.out.println("ERROR\nTry again");
		break;
		
		}
	}

	public void infoParking(){
		a.reset();
		a.updateParkingCars();
		System.out.println("Filter the search by:\n"+
							" (1) A range of years\n"+
							" (2) Older and newer\n"+
							" (3) Percentage of occupancy\n"
							);

		String select = sc.nextLine();

		switch(select){

			case "1":

				System.out.println("Type the minor year");
				int minorYear = sc.nextInt();
				sc.nextLine();

				System.out.println("Type the major year");
				int majorYear = sc.nextInt();
				sc.nextLine();

				a.forYears(minorYear, majorYear);

			break;

			case"2":
				a.newerAndOlder();
			break;

			case"3":
				System.out.println(a.percentage());
			break;

			default:
				System.out.println("Select one option");
			break;
		}
	}

	public void setDocuments2Test(){
			a.addDocuments("12345", 235477, 2022, 324635, 534545, 2022, 435326, 234344, 2022);
			a.addDocuments("1", 235477, 2022, 324635, 534545, 2022, 435326, 234344, 2022);
			System.out.println("Updated documents");
	}

	public String createVehicle(){

		//Creating documents
		System.out.println("\n\tDocuments\n");

		System.out.println("\nSOAT\n");
    	System.out.println("has:\n (1)Yes\n (2)No");
    	String soatType = sc.nextLine();
    	double priceSOAT = -1;
    	int yearSOAT = -1;
      	double coverageAmount = -1;

	    if (soatType.equals("1")){
			System.out.println("Price:");
			priceSOAT = sc.nextDouble();
			sc.nextLine();
			System.out.println("Year:");
			yearSOAT = sc.nextInt();
			sc.nextLine();
			System.out.println("Coverage amount:");
			coverageAmount = sc.nextDouble();
			sc.nextLine();
      	} else if (soatType.equals("2")) {
      		System.out.println("NO SOAT");
      	}

      	System.out.println("\nTechnical-mechanical review\n"+
    						"has:\n (1)Yes\n (2)No"
    						);	
    	String reviewType = sc.nextLine();
    	double priceReview = -1;
    	int yearReview = -1;
      	double gasReleased = -1;

      	if (reviewType.equals("1")){
			System.out.println("Price:");
			priceReview = sc.nextDouble();
			sc.nextLine();
			System.out.println("Year:");
			yearReview = sc.nextInt();
			sc.nextLine();
	    	System.out.println("Gas released:");
	    	gasReleased = sc.nextDouble();
			sc.nextLine();     		
      	} else if (reviewType.equals("2")){
			System.out.println("NO TECHNICAL MECHANICAL REVIEW");
      	}


		System.out.println("\nOwnership Card\n");
    	System.out.println("has:\n (1)Yes\n (2)No");
    	String cardType = sc.nextLine();


    	double priceCard = -1;
    	int yearCard = -1;	
	    	if (cardType.equals("1")){

	    			System.out.println("Price:");
					priceCard = sc.nextDouble();
					sc.nextLine();
					System.out.println("Year:");
					yearCard = sc.nextInt();
					sc.nextLine();

	    	} else if (cardType.equals("2")){
	    		System.out.println("Don't buy stolen\n Make sure you have an ownership card");
			}


		//Star creating the vehicle

		System.out.println("\n\tVehicle information\n");

		System.out.println("Vehicle status:\n (1)New\n (2)Used");
		String status = sc.nextLine();  //enum Status

		System.out.println("ID:");
		String id = sc.nextLine();
		id = id.toLowerCase();

		System.out.println("Base price:");
		double basePrice = sc.nextDouble();
		sc.nextLine();

		System.out.println("Brand:");
		String brand = sc.nextLine();
		brand = brand.toLowerCase();

		System.out.println("Model:");
		int model = sc.nextInt();
		sc.nextLine();

		System.out.println("Cubic capacity:");
		double cc = sc.nextDouble();
		sc.nextLine();

		System.out.println("Kilometers:");
		double km = sc.nextDouble();
		sc.nextLine();

		System.out.println("License Plate:");
		String licensePlate = sc.nextLine();
		licensePlate = licensePlate.toUpperCase();


		//For type

		System.out.println("Select a vehicle type:\n"+
							" (1) Car\n"+
							" (2) Motorcicle\n"
							);
		String vehicleType = sc.nextLine();


		double gallonsCapacity = 0;
		double gallonsForKm = 0;
		switch (vehicleType){

			case "1": //car

				System.out.println("Select a car type:\n"+ //car type
					" (1) Pickup\n"+
					" (2) Sedan\n"
					);
				String carType = sc.nextLine(); //Enum car type

				System.out.println("Battery life: ");
				int doorsNumber = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Polarized:\n"+
									" (1) Yes\n"+
									" (2) No\n"
									);

				String polarizedAsString = sc.nextLine();
				boolean polarized = false;
				if (polarizedAsString.equals("1")){
					polarized = true;
				}

				System.out.println("Select a car template:\n"+
									" (1) Fuel\n"+
									" (2) Electric\n"+
									" (3) Hybrid\n"
									);	
				String carTemplate = sc.nextLine(); //Daughter classes

				double batteryLife = 0;
				double kWForKm = 0;
				String chargeType = "";
				String fuelType = "";

				if (carTemplate.equals("1") || carTemplate.equals("3")){	//Fuel

					System.out.println("Gallons capacity: ");
					gallonsCapacity = sc.nextDouble();
					sc.nextLine();
					System.out.println("Gallons/Kilometer: ");
					gallonsForKm = sc.nextDouble();
					sc.nextLine();

					System.out.println("Select a fuel type:\n"+
										" (1) Premium\n"+
										" (2) Regular\n"+
										" (3) Diesel\n"
										);
					fuelType = sc.nextLine();	//Enum fuel type

					if (carTemplate.equals("1")){ //Add fuel car
					a.addFuelCar(id, basePrice, brand, model, cc, km, licensePlate, status, doorsNumber, polarized, carType, gallonsCapacity, gallonsForKm, fuelType, priceSOAT, yearSOAT, coverageAmount, priceReview, yearReview, gasReleased, priceCard, yearCard);
					}
				} 

				if (carTemplate.equals("2") || carTemplate.equals("3")){	//Battery

					System.out.println("Battery life: ");
					batteryLife = sc.nextDouble();
					sc.nextLine();
					System.out.println("kilowatts/Kilometer: ");
					kWForKm = sc.nextDouble();
					sc.nextLine();


					System.out.println("Select a fuel type:\n"+
										" (1) Fast charge\n"+
										" (2) Regular charge\n"
										);
					chargeType = sc.nextLine();	//Enum charge type
					if (carTemplate.equals("2")){ //Add Electric car
					a.addElectricCar(id, basePrice, brand, model, cc, km, licensePlate, status, doorsNumber, polarized, carType, batteryLife, kWForKm, chargeType, priceSOAT, yearSOAT, coverageAmount, priceReview, yearReview, gasReleased, priceCard, yearCard);
					}
				}

				if (carTemplate.equals("3")){ //Add Hybric car
					a.addHybridCar(id, basePrice, brand, model, cc, km, licensePlate, status, doorsNumber, polarized, carType, batteryLife, kWForKm, chargeType, gallonsCapacity, gallonsForKm, fuelType, priceSOAT, yearSOAT, coverageAmount, priceReview, yearReview, gasReleased, priceCard, yearCard);
				}

			break;

			case "2": //Motorcicle

				System.out.println("Gallons capacity: ");
				gallonsCapacity = sc.nextDouble();
				sc.nextLine();
				System.out.println("Gallons/Kilometer: ");
				gallonsForKm = sc.nextDouble();
				sc.nextLine();

				String motorcicleType = "0";
				System.out.println("Select a motorcicle type:\n"+
									" (1) Standard\n"+
									" (2) Sport\n"+
									" (3) Scooter\n"+
									" (4) Croos\n"
									);
				motorcicleType = sc.nextLine(); //Enum motorcicle type

				a.addMotorcicle(id, basePrice, brand, model, cc, km, licensePlate, status, gallonsCapacity, gallonsForKm, motorcicleType, priceSOAT, yearSOAT, coverageAmount, priceReview, yearReview, gasReleased, priceCard, yearCard);

			break;

			default:
				System.out.println("Please choose one option");
			break;
		}

		return "¡Vehicle was created!";

	}

	public void price(){

		System.out.println("Type the vehicle id:");
		String searchID = sc.nextLine();

		System.out.println("Additional discount (the positive number):");
		double additional = sc.nextDouble();
		sc.nextLine();

		System.out.println("Price = "+a.calculateTotalPrice(searchID, additional)+"");
	}

	public void searchVehicle(){

		System.out.println("Select one option:\n"+
							" (1) Vehicle type\n"+
							" (2) Fuel type\n"+
							" (3) Status (NEW/USED)\n"
							);

		String select = sc.nextLine();

		switch (select){
			case "1":

				System.out.println("Select the vehicle type:\n"+
							" (1) Car\n"+
							" (2) Motorcicle\n"
							);
				String vType = sc.nextLine();
				a.printForVType(vType);

			break;

			case "2":

				System.out.println("Choose one option:\n"+
							" (1) Print only charge vehicles\n"+
							" (2) Print only fuel vehicles\n"+
							" (3) Print only Charge and fuel vehicles\n"
							);

				String fType = sc.nextLine();
				a.printForFType(fType);
				
			break;

			case "3":

				System.out.println("Select one status:\n"+
							" (1) New\n"+
							" (2) Used\n"
							);

				String st = sc.nextLine();
				a.printForSt(st);

			break;

			default:
				System.out.println("Please enter a valid number");
			break;
		}
	}

	public void showDocuments(){

		System.out.println("Type the vehicle ID");
		String typedID = sc.nextLine();

		System.out.println("\n\nDOCUMENT INFORMATION\n"+
							"SOAT: "+a.decodeSOAT(typedID)+"\n"+
							"Technical-mechanical check: "+a.decodeReview(typedID)+"\n"+
							"Ownership card: "+a.decodeOwnershipCard(typedID)+"\n"
							//"\n\nPicture:\n"
							);
		// a.printPicture(typedID);
		// System.out.println();
	}


	public void printParking(){
		a.callShowParking();
	}


	/**
	* Descripción: ¿qué hace mi método? (concisa, un par de líneas)<br>
		* <b> pre:<b> ¿cuáles son las condiciones sobre las variables globales? --> si hay una condición sobre var glob. <br>
		* <b> pos:<b> ¿Cuales fueron los cambios sobre las variables globales? --> si ocurrio un cambio cn var glob.
		* @param <nombre_par> <tipo>, condiciones sobre el parametro --> si tiene
		* @return <nombre_var> <tipo>, informacion sobre variable de retorno --> retorno
	*/
}