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

import com.cog.hotels.model.reviews;
import com.cog.hotels.service.reviewService;

@RestController
public class reviewController {
	@Autowired
	private reviewService rr;
	
	@CrossOrigin(origins = "https://gatheaditya.github.io", maxAge = 3600)
	public @ResponseBody Page<reviews> get(@PathVariable("pageid") int pageid)
	{
		return rr.findAll(new PageRequest(pageid,12));
		
	}
	
	@GetMapping("/getreviews")
	@CrossOrigin(origins = "https://gatheaditya.github.io", maxAge = 3600)
	public @ResponseBody List<reviews> getHotels()
	{
		return rr.getHotels();
	}
	
	@GetMapping("/getreviews/{id}")
	@CrossOrigin(origins = "https://gatheaditya.github.io", maxAge = 3600)
	public @ResponseBody Page<reviews> getHotel(@PathVariable int id)
	{
	return rr.findAll(new PageRequest(id,10));	
	}
	
	@GetMapping("/getreviewsDetails/{id}")
	@CrossOrigin(origins = "https://gatheaditya.github.io", maxAge = 3600)
	public @ResponseBody reviews getReviewsDetails(@PathVariable int id)
	{
		return rr.findById(id);
	}

}
