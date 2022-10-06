package com.hfile.demo.pll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.file.demo.bll.Car;

public class CarList {
	private String filename;
	public CarList(String filename) {
		filename =filename;
	}
	public int countNewCars() throws IOException{
		FileReader fr =new FileReader(filename);
		BufferedReader br =new BufferedReader(fr);
		int count =0;
		Car c =Car.read(br);
		while(c!=null) {
			if(c.getKm()==0)
				count++;
			c= Car.read(br);
		}
		br.close();
		return count;
	}
	public Car mostExpensiveCar() throws IOException {
	    // this is the second alternative for opening a file for reading
	    FileInputStream is = new FileInputStream(filename);
	    InputStreamReader isr = new InputStreamReader(is);
	    BufferedReader br = new BufferedReader(isr);

	    double max = 0;
	    Car cmax = null;
	    Car c = Car.read(br);
	    while (c != null) {
	      if (c.getPrice() > max) {
	        max = c.getPrice();
	        cmax = c;
	      }
	      c = Car.read(br);
	    }
	    br.close();
	    return cmax;
	  }

	  public void addCar(Car c) throws IOException {
	    FileWriter fw = new FileWriter(filename, true); //open file in append mode
	    PrintWriter pw = new PrintWriter(fw);

	    pw.println(c.getModel());
	    pw.println(c.getYear());
	    pw.println(c.getKm());
	    pw.println(c.getPrice());
	    pw.close();
	  }

	  public void removeCar(Car c) throws IOException {
	    File f = new File(filename);
	    FileInputStream is = new FileInputStream(f);
	    InputStreamReader isr = new InputStreamReader(is);
	    BufferedReader br = new BufferedReader(isr);

	    // this is the second alternative for opening a file for writing
	    File ftemp = new File("car.txt");
	    FileOutputStream os = new FileOutputStream(ftemp);
	    PrintWriter pw = new PrintWriter(os);

	    Car curr = Car.read(br);
	    while (curr != null) {
	      if (!curr.equalTo(c)) {
	        pw.println(curr.getModel());
	        pw.println(curr.getYear());
	        pw.println(curr.getKm());
	        pw.println(curr.getPrice());
	      }
	      curr = Car.read(br);
	    }
	    br.close();
	    pw.close();

	    ftemp.renameTo(f);
	  }
	}


