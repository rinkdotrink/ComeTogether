package de.ct.shared;

import java.awt.Image;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private long id;
	private String name;
	private String email;
	private String gender;
	private Calendar birthday;
	private String password;
	private Image image;

	public long getId() {
		return id;
	}

	public void setId(final long aId) {
		this.id = aId;
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

	public Image getImage() {
		return image;
	}

	public void setImage(final Image aImage) {
		this.image = aImage;
	}
	
	public boolean equals(Object object){
		User user = (User) object;
		return this.id == user.id;
	}
	
	public int hashCode(){
		return (int) this.id % 1000;
	}

}
