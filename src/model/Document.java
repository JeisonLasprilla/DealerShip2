package model;
import java.util.*;

public abstract class Document{
	
	protected double price;
	protected int year;
	protected int [][] picture;
	public static final int L = 4;

	public Document(double price, int year){ 
		this.price = price;
		this.year = year;
		picture = new int[L][L];
	}

	public abstract String decodeDocument();

	public void printMatrix(){
		for (int i = 0; i < L; i++){
			for (int j = 0; j < L; j++){
				 System.out.print (+picture[i][j]+" ");
			}
			System.out.println();
		}
	}
}