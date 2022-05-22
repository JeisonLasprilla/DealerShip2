package model;
import java.util.*;

public class Review extends Document{
	
	private double gasReleased;

	public Review(double price, int year, double gasReleased){ 
		super(price, year);
		this.gasReleased = gasReleased;
	}

	public double getGasReleased(){
		return gasReleased;
	}

	public void setGasReleased(){
		this.gasReleased = gasReleased;
	}

	@Override
	public String decodeDocument(){

		String document = "";
		int vertical = -1; //to move between colunms
		int horizontal = -1; //to move between the rows
		boolean start1 = true;
		boolean start2 = false; 
		boolean start3 = false;

		int a,b,c;

			for (int i = 0; i < L; i++){
				for (int j = 0; j < L; j++){

						 // 	a = picture[i][j];
							// document = document+a+"";


						//First horizontal line
						if (start1 == true && j == horizontal+1){
							a = picture[i][j];
							document = document+a+"";
							horizontal++;

							if(horizontal == L-1){
								start1 = false;
								start2 = true;
								vertical = 0;
								horizontal = L-1;
							}
						} 

						//Oblique line
						if (start2 == true && i == vertical+1 && j == horizontal-1 ){
							b = picture[i][j];
							document = document+b+"";
							horizontal--;
							vertical++;

							if(vertical == L-1 && horizontal == 0){
								start2 = false;
								start3 = true;
								horizontal = 0;
							}
						}

						//Second Horizontal line
						if(start3 == true && j == horizontal+1){
							c = picture[i][j];
							document = document+c+"";
							horizontal++;
						}						
				}
			}

		return document;
	}

}