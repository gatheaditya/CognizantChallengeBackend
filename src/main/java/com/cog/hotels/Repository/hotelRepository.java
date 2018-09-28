package com.cog.hotels.Repository;

import java.util.List;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cog.hotels.model.countProvince;
import com.cog.hotels.model.hotel;



@Service
public interface hotelRepository extends CrudRepository<hotel, Long> {
	
	public List<hotel> findAll();
	Page<hotel> findAll(Pageable pageable);
     public hotel findById(int hid);
     public List<hotel> findByCity(String name);
     @Query("select Distinct city from hotel")
     public List<String> findDistinctCity();
     @Query(value="select new com.cog.hotels.model.countProvince(h.province, count(h.province)) from hotel as h    group By h.province  having count(h.province)>20 order by count(h.province) desc")     
     public List<countProvince> findCityAndProvince();


}
