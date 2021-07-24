package com.revature.beans;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
	private static final long serialVersionUID = 1L; //Serializable demand this. Never used
	
	private String fname;
	private String lname;
	private String email;
	private LocalDate bday;
	private UserType type;
	private Integer ffid;
	private Long miles;
	private String title;
	private String reservation;
	
	public User() {
		super();
		this.type = UserType.PASSENGER;
		this.miles = 0l;
		this.title = "";
		this.bday = LocalDate.of(1990, 01, 01);
	}
	
	public User(String title, String fname, String lname, String email) {
		this();
		this.title = title;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}
	
	public User(String title, String fname, String lname, String email, LocalDate bday) {
		this();
		this.title = title;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.bday = bday;
	}
	                                                    
	public User(Integer ffid, String title, String fname, String lname, String email, LocalDate bday) {
		this();
		this.ffid = ffid;
		this.title = title;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.bday = bday;
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

	public Integer getFfid() {
		return ffid;
	}

	public void setFfid(Integer ffid) {
		this.ffid = ffid;
	}

	public Long getMiles() {
		return miles;
	}

	public void setMiles(Long miles) {
		this.miles = miles;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReservation() {
		return reservation;
	}

	public void setReservation(String reservation) {
		this.reservation = reservation;
	}

	//***********************   HashCode and toString   ****************************
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bday == null) ? 0 : bday.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((ffid == null) ? 0 : ffid.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + ((miles == null) ? 0 : miles.hashCode());
		result = prime * result + ((reservation == null) ? 0 : reservation.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (ffid == null) {
			if (other.ffid != null)
				return false;
		} else if (!ffid.equals(other.ffid))
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
		if (reservation == null) {
			if (other.reservation != null)
				return false;
		} else if (!reservation.equals(other.reservation))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

		//****************************   toString   ************************************
		@Override
		public String toString() {
			return "" + title  + lname + ", " + fname + "\nFrequent Flyer number: " + ffid +
					"\nStatus: " + type + "\nMiles: " + miles + "\nDOB: " + bday + 
					"\nEmail: " + email;
		}
	
}
