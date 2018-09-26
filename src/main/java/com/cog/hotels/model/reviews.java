package com.cog.hotels.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class reviews implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4468670817477259104L;
	@Id
	private int id;
	private int ratings;
	private String text;
	private String title;
	private String username;	
	private hotel hotel;
	public reviews()
	{
		
	}
	public reviews(int id, int ratings, String text, String title, String username) {
		super();
		this.id = id;
		this.ratings = ratings;
		this.text = text;
		this.title = title;
		this.username = username;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public hotel getHotel() {
		return hotel;
	}
	public void setHotel(hotel hotel) {
		this.hotel = hotel;
	}

}
