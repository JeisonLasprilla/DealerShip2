package model;
import java.util.*;

public class OwnershipCard extends Document{

	public OwnershipCard(double price, int year){ 
		super(price, year);
	}

	@Override
	public String decodeDocument(){

		String document = "";
		int a;

			for (int i = L-1; i >= 0; i--){
				for (int j = L-1; j >= 0; j--){
					
					if (i == 0 && j == 0){
						//I just don't want it to print 
					} else if ((i+j)%2 == 0){
						a = picture[i][j];
						document = document+a+"";
					}
				}
			}

		return document;
	}

}