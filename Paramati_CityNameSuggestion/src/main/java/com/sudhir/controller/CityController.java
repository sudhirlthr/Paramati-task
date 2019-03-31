package com.sudhir.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sudhir.service.CityService;

@RestController
public class CityController{
	@Autowired
	CityService cityService;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String checkURL() {
		return "Hi There";
	}
	
	@RequestMapping(path="/suggest_cities", method=RequestMethod.GET)
	@ResponseBody
	public List<String> getAllSuggestedCities(@RequestParam("start") String start, @RequestParam("atmost") Integer atmost) throws JsonGenerationException, JsonMappingException, IOException{

		System.out.println("start = "+start+", atmost = "+atmost);
		List<String> allSuggestedWord = cityService.getAllSuggestedWord(start);
		if(allSuggestedWord.size() > atmost)
			return allSuggestedWord.subList(0, atmost);
		else
			return allSuggestedWord;
	}
}
