package com.example.pojo;

import javax.jdo.annotations.*;
@PersistenceCapable(detachable = "true")

public class User {

	@PrimaryKey
    private int code;
    private String name;
    private String surname;
    private String email;
    private String password;

    

	// Default public constructor required for serialization
    public User() {
    }

    public User(int code) {
        this.code = code;
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**Constructor for the User class.
     * @param code
     * @param name
     * @param surname
     * @param email
     * @param password
     */
    public User(int code, String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.code = code;
        this.email = email;
        this.password = password;
        
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    @Override
    public String toString() {
        return String.format("%d - %s %s", code, name, surname);
    }
    
    @Override
    public boolean equals(Object obj) {
    	// TODO Auto-generated method stub
    	return this.code == ((User)obj).getCode();
    }
}
