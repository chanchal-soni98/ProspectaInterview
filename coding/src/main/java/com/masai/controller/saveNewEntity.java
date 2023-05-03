package com.masai.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
@Controller
public class saveNewEntity {
	
	  @PostMapping("/api/saveNewEntity")
	  public Map<String, Object> saveEntry(@RequestBody Map<String, Object> entry) {
		  
		  
	    RestTemplate restTemplate = new RestTemplate();
	    
	    HttpHeaders hh = new HttpHeaders();
	    
	    hh.add("Content-Type","application/json");  // json data
	    
	    
	    hh.setAccept((List<MediaType>) MediaType.APPLICATION_JSON);
	    
	    HttpEntity<Map<String, Object>> newEntity = new HttpEntity<>(entry, hh);
	    
	    
	    Map<String, Object> data = restTemplate.postForObject("https://api.publicapis.org/entries", newEntity, Map.class);//Sending Post Request
	    
	    return data;
	  }

}
