package com.revature.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


public class User implements Serializable {
	private static final long serialVersionUID = 1L; //Serializable demand this. Never used
	
	private Integer userid;
	private String fname;
	private String lname;
	private String email;
	private LocalDate bday;
	private UserType type;
	private Integer ff;
	private Long miles;
	private static int ffnumber;
	
	public User() {
		super();
		this.type = UserType.PASSENGER;
	}
	                                                    
	public User(Integer userid, String fname, String lname, String email, LocalDate bday) {
		this();
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.bday = bday;
	}
	
	public User(Integer userid, String fname, String lname, String email, LocalDate bday, Integer ff) {
		this();
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.bday = bday;
		this.ff = ff;
	}
	
//**********************   Getters and Setters   *******************************

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBday() {
		return bday;
	}

	public void setBday(LocalDate bday) {
		this.bday = bday;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public Integer getFF() {
		return ff;
	}

	public void setFF(Integer ff) {
		this.ff = ff;
	}

	public Long getMiles() {
		return miles;
	}

	public void setMiles(Long miles) {
		this.miles = miles;
	}

	public static int getFfnumber() {
		return ffnumber;
	}

	public static void setFfnumber(int ffnumber) {
		User.ffnumber = ffnumber;
	}
//*********************   Hash Code and Equals   *******************************
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bday == null) ? 0 : bday.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((ff == null) ? 0 : ff.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + ((miles == null) ? 0 : miles.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (bday == null) {
			if (other.bday != null)
				return false;
		} else if (!bday.equals(other.bday))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (ff == null) {
			if (other.ff != null)
				return false;
		} else if (!ff.equals(other.ff))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (miles == null) {
			if (other.miles != null)
				return false;
		} else if (!miles.equals(other.miles))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	//****************************   toString   ************************************
		@Override
		public String toString() {
			return "Name: " + lname + ", " + fname + "\nFrequent Flyer number: " + ff +
					"\nStatus: " + type + "\nMiles: " + miles + "\nDOB: " + bday + 
					"\nEmail: " + email;
		}
	
}
