package com.sudhir.service;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sudhir.model.CityName;

@Service
public class CityService {
	
	public List<String> getAllSuggestedWord(String typedWord){
		Set<String> citySets = new CityName().getCityList();
		List<String> suggestedWords = citySets.stream().filter(s -> s.startsWith(typedWord)).collect(Collectors.toList());
		return suggestedWords;
	}
}
