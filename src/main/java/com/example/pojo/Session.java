package com.example.pojo;

import java.sql.Date;

public class Session {

		private int code;
		private Date date;
		
		public Session(){
			
		}
		
		public Session(int code, Date date) {
			this.code = code;
			this.date = date;
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
}
