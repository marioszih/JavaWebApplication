package model;

import java.sql.Date;

public class User {
	private int id;
    private String name;
    private String surname;
    private String gender;
    private Date birthdate;
    private String workAddress;
    private String homeAddress;

    /*
     * Setters
     */
    public void setBirthdate(Date date) {
        this.birthdate = date;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }
    
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * Getters
	 */
    public Date getBirthdate() {
        return birthdate;
    }

    public String getGender() {
        return gender;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

	public String getWorkAddress() {
		return workAddress;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public int getId() {
		return id;
	}

}
