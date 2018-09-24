package com.cog.hotels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cog.hotels.Repository.reviewsRepository;
import com.cog.hotels.model.reviews;

@Service
public class reviewService {
	@Autowired
	private reviewsRepository rr;
	
	public List<reviews> getHotels()
	{
		return  rr.findAll();
	}

	public Page<reviews> findAll(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return rr.findAll(pageRequest);
	}

	public reviews findById(int id)
	{
		return rr.findById(id);
	}

}
