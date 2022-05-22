package model;
import java.util.*;

public class Parking{

	protected String [][] matrixParking;
	protected Vehicle [][] parkingCars;
	public static final int B = 5;
	public static final int H = 10;
	
	public Parking(){
		matrixParking = new String [H][B];
		parkingCars = new Vehicle [H][B];

		for (int i = 0; i < H; i++){
			for(int j = 0; j < B; j++){

				matrixParking[i][j] = "[ ]"; 

										// " _______________________     \n"+
										// "|                       |    \n"+
										// "|      FREE PLACE       |    \n"+
						                // "|        ___	        |    \n"+
										// "|   ____//_]|________   |    \n"+
										// "|  ( o_ |  -|   _  o|   |    \n"+
										// "|   `(_)-------(_)--'   |    \n"+
										// "|                       |    \n"+
										// "|_______________________|    \n";

			}
		}
	}

	public void showParking(){
		for (int i = 0; i < H; i++){
			for(int j = 0; j < B; j++){
				System.out.print(matrixParking[i][j]+" ");
			}
			System.out.println("\n");
		}		
	}

	public boolean parkingCarsHasSpace(){
		boolean hasSpace = false;
		for (int i = 0; i < H && hasSpace == false; i++){
			for(int j = 0; j < B && hasSpace == false; j++){
				if (parkingCars[i][j] == null){
					hasSpace = true;
				}
			}
		}	
		return hasSpace;
	}

	public void resetMatrix(){
		for (int i = 0; i < H; i++){
			for(int j = 0; j < B; j++){

				matrixParking[i][j] = "[ ]";
				parkingCars[i][j] = null;
			}
		}
	}

	public int emptyI(int column){
		boolean end = false;
		int empty = -2;
		for (int i = 0; i < H && end == false; i++){
				
			if(parkingCars[i][column] == null && end == false){ //El carro se está guardando en la primera posición el que no funciona bien es el que dibuja
				empty = i;
				matrixParking[empty][column] = "[X]";
				end = true;
			}
		}
		return empty;
	}

	public int calculatePercentage(){
		
		int count = 0;
		for (int i = 0; i < H; i++){
			for(int j = 0; j < B; j++){
				if(parkingCars[i][j]!=null){
					count++;
				}
			}
		}

		count = (count * 100)/50;

		return count;
	}

	public void printForYears(int minorYear, int majorYear){

		for (int i = 0; i < H; i++){
			for(int j = 0; j < B; j++){

				if(parkingCars[i][j] != null && minorYear < parkingCars[i][j].model && parkingCars[i][j].model < majorYear){
					System.out.println(parkingCars[i][j].toString());
				}
			}
		}
	}

	public String olderCar(){

		String older = "";
		int olderI = -1;
		int olderJ = -1;
		boolean end = false;

	 	if (parkingCars[0][0] != null){

	 		olderI = 0;
	 		olderJ = 0;
	 		
	 	} else {
	 		older = "There are not cars";
	 		end = true;

	 	}

		for (int i = 0; i < H && end == false; i++){
			for(int j = 0; j < B; j++){
				if(parkingCars[i][j] != null && parkingCars[i][j].model < parkingCars[olderI][olderJ].model){
					olderI = i;
					olderJ = j;
				}
			}
		}

		older = parkingCars[olderI][olderJ].toString();

		return older;
	
	}

	public String newerCar(){

		int newerI = -1;
		int newerJ = -1;
		String newer = "";
 		boolean end = false;

	 	if (parkingCars[0][0] != null){
	 		
	 		newerI = 0;
	 		newerJ = 0;
	 		
	 	} else {
	 		newer = "There are not cars";
	 		end = true;
	 	}

		for (int i = 0; i < H && end == false; i++){
			for(int j = 0; j < B; j++){
				if(parkingCars[i][j] != null && parkingCars[i][j].model > parkingCars[newerI][newerJ].model){
					newerI = i;
					newerJ = j;
				}
			}
		}

		newer = parkingCars[newerI][newerJ].toString();

		return newer;
	
	}

}