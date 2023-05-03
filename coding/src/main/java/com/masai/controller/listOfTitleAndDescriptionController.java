package com.masai.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class listOfTitleAndDescriptionController {
	
//		Using https://api.publicapis.org/ complete the following tasks in any language/server.
//		 
//		Create an API that lists the title, description based on the category passed as an 
//		input parameter.


	
	
	  @GetMapping("/category/{cat}")
	  public List<Map<String, String>> getListTitleAndDescription(@PathVariable String cat) {
		  
	    RestTemplate restTemplate = new RestTemplate();
	    
	    String url = "https://api.publicapis.org/entries?category=" + cat;//url for category,  
	    
	    Map<String, Object> data = restTemplate.getForObject("https://api.publicapis.org/entries?category=" + cat, Map.class);//url Mapping
	    
	    List<Map<String, String>> listofTilteAndDescription = new ArrayList<Map<String, String>>();
	    
	    List<Map<String, String>> lists = (List<Map<String, String>>) data.get("entries");
	    
	    for (Map<String, String> map : lists) {  //GET /entries
	      Map<String, String> m = new HashMap<>(); // create map using HashMap Class. 
	      m.put("Title", map.get("API"));  // put title in map
	      m.put("Description", map.get("Description"));// put Description in map
	      listofTilteAndDescription.add(m);
	    }
	    
	    return listofTilteAndDescription;
	  }
	  

	  
}


