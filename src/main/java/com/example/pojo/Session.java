package com.example.pojo;

import javax.jdo.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;
@PersistenceCapable(detachable = "true")

public class Session {

		@PrimaryKey
		private int code;
		private Date date;
		private String time;
		private int film;

		
		public Session(){
			
		}
		
		public Session(int code, Date date, String time, int film) {
			this.code = code;
			this.date = date;
			this.time = time;
			this.film = film;

		}


		public int getCode() {
			return code;
		}
		
		public void setCode(int code) {
			this.code = code;
		}
		
		public Date getDate() {
			return date;
		}
		
		public void setDate(Date date) {
			this.date = date;
		}
		
		@Override
	    public String toString() {
			SimpleDateFormat sdf = new SimpleDateFormat(
				    "yyyy-MM-dd");
	        return String.format("Sesion %s: %s %s", code, sdf.format(date), time);
	    }
		
		public String getTime() {
			return time;
		}
		
		public int getFilm() {
			return film;
		}
		
		public void setFilm(int film) {
			this.film = film;
		}
}
