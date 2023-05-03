package com.masai.theory;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import com.opencsv.CSVReader;

public class TheoryChallenge {
	
	public static void main(String[] args) throws Exception  {   
	  
	    	
	        FileReader filereader = new FileReader("F: file");
	  
	        CSVReader reader = new CSVReader(filereader);
	        String[] array;

	        while ((array = reader.readNext()) != null) {
	            for (String el : array) {
	                System.out.print(el);
	            }
	            System.out.println();
	        }
	    
	}  
	

}
