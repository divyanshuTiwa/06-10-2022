package com.hfile.demo.pll;

import java.io.File;

import com.file.demo.bll.Car;

public class TestCar {
	public static void main(String[] args) {
		try {
		Car c1= new Car("D001,2022,0,270000",0,0,0);
		Car c2= new Car("D002,2021,0,180000",0,0,0);
		Car c3= new Car("D003,2020,0,190000",0,0,0);
		Car c4= new Car("D004,2019,0,250000",0,0,0);
		Car c5= new Car("D005,2018,0,220000",0,0,0);
		Car c6= new Car("D006,2017,0,260000",0,0,0);
		Car c7= new Car("D007,2016,0,230000",0,0,0);
		Car c8= new Car("D008,2015,0,210000",0,0,0);
		Car c9= new Car("D009,2014,0,20000",0,0,0);
		Car c10= new Car("D010,2013,0,240000",0,0,0);
		
		Car[] cars =new Car[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10};
		File f= new File("cars-temporary.txt");
		f.delete();
		
		CarList carlist = new CarList("cars-temporary.txt");
		for(Car c:cars) {
			carlist.addCar(c);
		}
		System.out.println("New cars: "+carlist.countNewCars());
		System.out.println("Most expensive Car :"+carlist.mostExpensiveCar());
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		}
		}
