package com.example.pojo;

import java.util.Map;

public class Film {
	
	private int code;
	private String name;
	private int year;
	private Map<Integer, Session> sessions;
	
	public Film() {
		
	}
	
	public Film(int code, String name, int year, Map<Integer, Session> sessions) {
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
	
	public Map<Integer, Session> getSessions() {
		return sessions;
	}
	
	public void setSessions(Map<Integer, Session> sessions) {
		this.sessions = sessions;
	}

}
