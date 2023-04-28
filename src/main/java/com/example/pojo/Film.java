package com.example.pojo;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

import javax.jdo.annotations.*;
@PersistenceCapable(detachable = "true")

public class Film {
	
	@PrimaryKey
	private int code;
	private String name;
	private int year;
	@Join
	private ArrayList<Session> sessions;
	
	public Film() {
		
	}
	
	public Film(int code, String name, int year, ArrayList<Session> sessions) {
		this.code = code;
		this.name = name;
		this.year = year;
		this.sessions = sessions;
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
	
	public ArrayList<Session> getSessions() {
		return sessions;
	}
	
	public void setSessions(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}

}
