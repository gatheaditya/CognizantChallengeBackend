package com.cog.hotels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cog.hotels.Repository.hotelRepository;
import com.cog.hotels.model.hotel;

@Service
public class hotelService  {
	
	@Autowired
	private hotelRepository hr;
	
	public List<hotel> getHotels()
	{
		return  hr.findAll();
	}

	public Page<hotel> findAll(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return hr.findAll(pageRequest);
	}

	public hotel findById(int hid)
	{
		return hr.findById(hid);
	}
	public List<hotel> findByCity(String name) {
		// TODO Auto-generated method stub
		return hr.findByCity(name);
	}
	
}
