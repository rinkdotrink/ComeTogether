package de.ct.shared;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private long userId;
	private String name = "";
	private String email = "";
	private String gender = "";
	private Calendar birthday = new GregorianCalendar(1900, 0, 1);
	private String password = "";
	private String image = "";

	public long getUserId() {
		return userId;
	}

	public void setUserId(final long aId) {
		this.userId = aId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String aName) {
		this.name = aName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String aEmail) {
		this.email = aEmail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(final String aGender) {
		this.gender = aGender;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(final Calendar aBirthday) {
		this.birthday = aBirthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String aPassword) {
		this.password = aPassword;
	}

	public String getImage() {
		return image;
	}

	public void setImage(final String aImage) {
		this.image = aImage;
	}
	
	public boolean equals(Object object){
		User user = (User) object;
		return this.userId == user.userId;
	}
	
	public int hashCode(){
		return (int) this.userId % 1000;
	}

}
