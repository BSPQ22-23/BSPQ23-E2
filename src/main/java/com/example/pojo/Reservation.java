package com.example.pojo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class Reservation {

	@PrimaryKey
	private int code;
	private int row;
	private int seat;
	private Session session;
	private User reservoir;
	
	public Reservation() {
		
	}
	
	public Reservation(int code, int row, int seat, Session session, User reservoir) {
		this.code = code;
		this.row = row;
		this.seat = seat;
		this.session =  session;
		this.reservoir = reservoir;
	}
	
	public User getReservoir() {
		return reservoir;
	}

	public void setReservoir(User reservoir) {
		this.reservoir = reservoir;
	}

	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getSeat() {
		return seat;
	}
	
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	public Session getSession() {
		return session;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
