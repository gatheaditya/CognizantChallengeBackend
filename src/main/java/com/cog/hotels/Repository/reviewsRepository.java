package com.cog.hotels.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import com.cog.hotels.model.reviews;

public interface reviewsRepository extends CrudRepository<reviews,Long> {
	
	public List<reviews> findAll();
	Page<reviews> findAll(Pageable pageable);
    public reviews findById(int id);

}
