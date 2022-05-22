package ui;
import java.util.*;

import model.*;

public class InitModel {
    
    public InitModel() { }

    public ArrayList <Vehicle> createVehicles(){
        ArrayList <Vehicle> vehicles = new ArrayList <Vehicle>();

        vehicles.add(new Electric("486102459", 30000000, "Renault", 2014, 2500, 85000, "VQA123", "2", 4, false, "2", 1, 100, "2"));
        vehicles.add(new Electric("123456789", 520000000, "Tesla", 2022, 2500, 0, "PLR323", "1", 4, true, "1", 1, 100, "1"));
        vehicles.add(new Fuel("370261921", 120000000, "Chevrolet", 2008, 2500, 150000, "QPB479", "2", 2, true, "2", 2, 0.200, "3"));
        vehicles.add(new Fuel("380228962", 150000000, "Jeep", 2012, 3500, 80000, "HLP204", "2", 2, true, "1", 2, 0.200, "2"));
        vehicles.add(new Fuel("584459186", 180000000, "Audi", 2022, 2500, 0, "CCG462", "1", 2, true, "2", 2, 0.200, "1"));
        vehicles.add(new Hybrid("508341460", 180000000, "Toyota", 2013, 3500, 110000, "KUN845", "2", 4, false, "2", 40, 40, "1", 2, 0.200, "3"));
        vehicles.add(new Hybrid("25294768", 230000000, "Mercedez", 2022, 3500, 0, "350VLV", "2", 4, false, "2", 40, 40, "1", 2, 0.200, "1"));
        vehicles.add(new Motorcicle("155738484", 300000, "Suzuki", 2011, 250, 98000, "823YSM", "2", 2, 0.200, "1")); 
        vehicles.add(new Motorcicle("198692122", 120000000, "BMW", 2022, 1000, 0, "918AYF", "1", 2, 0.200, "2"));

        return vehicles;
    }

}