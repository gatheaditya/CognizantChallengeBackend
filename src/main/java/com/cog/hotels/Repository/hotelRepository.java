package com.cog.hotels.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cog.hotels.model.hotel;



@Service
public interface hotelRepository extends CrudRepository<hotel, Long> {
	
	public List<hotel> findAll();
	Page<hotel> findAll(Pageable pageable);
     public hotel findById(int hid);
     public List<hotel> findByCity(String name);
	

}
