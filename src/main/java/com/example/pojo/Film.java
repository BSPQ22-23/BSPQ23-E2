package com.example.pojo;

import java.awt.List;
import java.util.ArrayList;


import javax.jdo.annotations.*;
@PersistenceCapable(detachable = "true")

public class Film {
	
	@PrimaryKey
	private int code;
	private String name;
	private int year;
	
	public Film() {
		
	}
	
	/**Constructor for the Film class.
	 * @param code
	 * @param name
	 * @param year
	 */
	public Film(int code, String name, int year) {
		this.code = code;
		this.name = name;
		this.year = year;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	

}
