package com.sudhir.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudhir.service.CityService;

@RestController	
public class CityController {
	@Autowired
	CityService cityService;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String checkURL() {
		return "Hi There";
	}
	
	@RequestMapping(path="/suggest_cities", method=RequestMethod.GET)
	@ResponseBody
	public List<String> getAllSuggestedCities(HttpServletResponse response, @RequestParam("start") String start, @RequestParam("atmost") Integer atmost){
		System.out.println("start = "+start+", atmost = "+atmost);
		response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
		List<String> allSuggestedWord = cityService.getAllSuggestedWord(start);
		if(allSuggestedWord.size() > atmost)
			return allSuggestedWord.subList(0, atmost);
		else
			return allSuggestedWord;
	}
}
