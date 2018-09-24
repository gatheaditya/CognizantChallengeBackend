package com.cog.hotels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cog.hotels.model.hotel;
import com.cog.hotels.service.hotelService;




@RestController
public class hotelController {
	
	@Autowired
	private hotelService hs;
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public @ResponseBody Page<hotel> get(@PathVariable("pageid") int pageid)
	{
		return hs.findAll(new PageRequest(pageid,12));
		
	}
	
	@GetMapping("/gethotels")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public @ResponseBody List<hotel> getHotels()
	{
		return hs.getHotels();
	}
	
	@GetMapping("/gethotels/{id}")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public @ResponseBody Page<hotel> getHotel(@PathVariable int id)
	{
	return hs.findAll(new PageRequest(id,10));	
	}
	@GetMapping("/gethotelsbyCity/{name}")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public @ResponseBody List<hotel> getHotelbyCity(@PathVariable String name)
	{
		return hs.findByCity(name);
	}
	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public @ResponseBody String welcome()
	{
		return "welcome";
	}
	@GetMapping("/gethotelDetails/{id}")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public @ResponseBody hotel getHotelDetails(@PathVariable int id)
	{
		return hs.findById(id);
	}
}
