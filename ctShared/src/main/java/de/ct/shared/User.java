package de.ct.shared;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class User implements Product {

	private long userId;
	private String name = "";
	private String email = "";
	private String gender = "";
	private Calendar birthday = new GregorianCalendar(1900, 0, 1);
	private String password = "";
	private String image = "";

	public User() {

	}

	public User(final long aUserId, final String aName, final String aEmail,
			final String aGender, final Calendar aBirthday,
			final String aPassword, final String aImage) {
		this.userId = aUserId;
		this.name = aName;
		this.email = aEmail;
		this.gender = aGender;
		this.birthday = aBirthday;
		this.password = aPassword;
		this.image = aImage;
	}

	public boolean equals(final Object aObject) {
		boolean isEqual = false;
		if ((aObject != null) && (aObject.getClass() == this.getClass())) {
			User user = (User) aObject;
			if ((this.userId == user.getUserId())
					&& (this.birthday.equals(user.getBirthday()))
					&& (this.email.equalsIgnoreCase(user.getEmail()))
					&& (this.gender.equalsIgnoreCase(user.gender))
					&& (this.image.equalsIgnoreCase(user.getImage()))
					&& (this.name.equalsIgnoreCase(user.getName()))
					&& (this.password.equalsIgnoreCase(user.getPassword()))
					){
				isEqual = true;
			}
		}
		return isEqual;
	}

	public int hashCode() {
		return (int) this.userId % 1000;
	}

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

}
