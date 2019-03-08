package com.cog.hotels.controller;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cog.hotels.model.countProvince;
import com.cog.hotels.model.hotel;
import com.cog.hotels.service.hotelService;




@RestController
@CrossOrigin(origins = "https://gatheaditya.github.io", maxAge = 3600)
public class hotelController {
	
	@Autowired
	private hotelService hs;
	private List<Integer> li = new ArrayList<>();
	
	public @ResponseBody Page<hotel> get(@PathVariable("pageid") int pageid)
	{
		return hs.findAll(new PageRequest(pageid,12));
		
	}
	
	@GetMapping("/getAllhotels")
	
	public @ResponseBody List<hotel> getHotels()
	{
		return hs.getHotels();
	}
	@GetMapping("/getAllcities")
	
	
	
public @ResponseBody List<String> getCities()
	{
		return hs.findDistinctCity();
	}
	
	@GetMapping("/gethotels/{id}")

	@Cacheable(value="hotelsByIdCache")
	
	public @ResponseBody Page<hotel> getHotel(@PathVariable int id)
	{
	return hs.findAll(new PageRequest(id,12));	
	}
	@GetMapping("/gethotelsbyCity/{name}")	
	public @ResponseBody List<hotel> getHotelbyCity(@PathVariable String name)
	{
		return hs.findByCity(name);
	}
	@GetMapping("/")	
	public @ResponseBody String welcome()
	{
		return "welcome";
	}
	@GetMapping("/gethotelDetails/{id}")	
	public @ResponseBody hotel getHotelDetails(@PathVariable int id)
	{
		return hs.findById(id);
	}
	@GetMapping("/getProvinceandcount")	
	public List<countProvince> test()
	{				
		return  hs.getProvinceCount();		
		
	}
	@GetMapping("/StreamPerformance")	
	public int  StreamPerformance()
	{		
		
	
			for(int i=0;i<10000;i++)
			{
				li.add(new Random(100).nextInt());
			}
		return li.size();
		long start = System.currentTimeMillis();
		int count =li.stream().count();		
		long end =System.currentTimeMillis();
		return count;
	}
	
	
	
}
