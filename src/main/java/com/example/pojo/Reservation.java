package com.example.pojo;


public class Reservation {

	private int row;
	private int seat;
	private Session session;
	
	public Reservation() {
		
	}
	
	public Reservation(int row, int seat, Session session) {
		this.row = row;
		this.seat = seat;
		this.session =  session;
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
}
