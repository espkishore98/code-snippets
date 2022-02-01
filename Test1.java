package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Cashapona\\Downloads\\sample.csv"));   
		List<List<String>> mainList= new ArrayList<>();
		String line="";
		while(( line=br.readLine()) != null)   //returns a boolean value  
		{  
		String[] stringArray = line.split(",");  
		List<String> sublist= Arrays.asList(stringArray);
		mainList.add(sublist);
		}
		System.out.println(mainList);
		List<String> header = mainList.get(0);
		List<Map<String,Object>> mappedList= new ArrayList<>();
		for(int row=1;row<=mainList.size()-1;row++) {
			Map<String,Object> mapper= new HashMap<String,Object>();
				for(int j=0;j<=mainList.get(row).size()-1;j++) {
					mapper.put(header.get(j), mainList.get(row).get(j));
			}
				mappedList.add(mapper);

		}
		System.out.println(mappedList);

		}  
	}
	

