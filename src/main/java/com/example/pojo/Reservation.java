package com.example.pojo;

import java.text.SimpleDateFormat;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class Reservation {

	@PrimaryKey
	private int code;
	private int row;
	private int seat;
	private int session;
	private int reservoir;
	
	public Reservation() {
		
	}
	
	public Reservation(int code, int row, int seat, int session, int reservoir) {
		this.code = code;
		this.row = row;
		this.seat = seat;
		this.session =  session;
		this.reservoir = reservoir;
	}
	
	public int getReservoir() {
		return reservoir;
	}

	public void setReservoir(int reservoir) {
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
	
	public int getSession() {
		return session;
	}
	
	public void setSession(int session) {
		this.session = session;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	@Override
    public String toString() {
        return String.format("Reserve %s: Seat: %s Row: %s", code, seat, row);
    }
}
