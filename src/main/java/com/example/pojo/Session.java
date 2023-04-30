package com.example.pojo;

import javax.jdo.annotations.*;
import java.util.Date;
@PersistenceCapable(detachable = "true")

public class Session {

		@PrimaryKey
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
