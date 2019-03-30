package com.sudhir.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class CityName {

	public Set<String> getCityList() {
		Set<String> city = new TreeSet<>();
		FileReader originalfile = null;
		BufferedReader bufferedReader = null;
		try {
			// originalfile = new FileReader("UniqueCity_Name.txt");
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("UniqueCity_Name.txt");
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String cityname = bufferedReader.readLine();
			while (cityname != null) {
				city.add(cityname);
				cityname = bufferedReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (originalfile != null)
				try {
					originalfile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return city;
	}
}
