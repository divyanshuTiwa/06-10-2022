package com.file.demo.bll;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FHandling02 {

	public static void main(String[] args) throws FileNotFoundException{
		new FHandling02().findLongestWords();
		}
		public String findLongestWords()throws FileNotFoundException{
			String longest_word = "";
			String current;
			Scanner sc = new Scanner(new File("C:\\Users\\admin\\eclipse-workspace\\Strings-exercise"));
			while(sc.hasNext()) {
				current =sc.next();
				if(current.length()>longest_word.length()) {
					longest_word = current;
				}
				}
			System.out.println("\n"+longest_word+"\n");
			return longest_word;
			}
			}


