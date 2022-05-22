package model;
import java.util.*;

public class SOAT extends Document{
	
	private double coverageAmount;

	public SOAT(double price, int year, double coverageAmount){ 
		super(price, year);
		this.coverageAmount = coverageAmount;
	}

	public double getCoverageAmount(){
		return coverageAmount;
	}

	public void setCoverageAmount(double coverageAmount){
		this.coverageAmount = coverageAmount;
	}

	@Override
	public String decodeDocument(){

		String document = "";
		int vertical = -1; //to move between colunms
		int horizontal = 0; //to move between the rows
		boolean end1 = false;
		int a,b;

			for (int i = 0; i < L; i++){
				for (int j = 0; j < L; j++){

						//Vertical line
						if(i == vertical+1 && end1 == false){
							
							a = picture[i][j];
							document = document+a+"";

							vertical++;
							if(vertical == L-1){
								end1 = true;
							}
						}

						//Horizontal line
						if (end1 == true && j == horizontal+1){
							b = picture[i][j];
							document = document+b+"";
							horizontal++;
						}
				}
			}

		return document;
	}

}