package com.file.demo.bll;

import java.io.BufferedReader;
import java.io.IOException;

public class Car {
			//representation of the objects of the class.
		private String model;
		private int year;
		private int km;
		private double price;
		public Car(String m, int y,int k,double p) {
			model =m; year =y; km= k; price=p;
		}
		@Override
		public String toString() {
			return model+ ", year: "+ year + ", km: "+ ",price: " + price;
			
		}
		public String getModel() {
			return model;
		}
		public int getYear() {
			return year;
		}
		public int getKm() {
			return km;
		}
		public double getPrice() {
			return price;
		}
		public boolean equalTo(Car c) {
			return this.model.equals(c.model)&&
					this.year== c.year &&
					this.km== c.km	&&
					this.price==c.price;
					
		}
		public static Car read(BufferedReader br)throws IOException{
			String s =br.readLine();
			if(s==null)
				return null;
			else
				return new Car(s,Integer.parseInt(br.readLine()),
						Integer.parseInt(br.readLine()),
						Double.parseDouble(br.readLine()));
		}
		}
		
