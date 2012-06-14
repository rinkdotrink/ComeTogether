package de.datagenerator.writer;

import java.io.IOException;

import de.ct.shared.Product;
import de.ct.shared.User;
import de.datagenerator.LogUtil;

public class UserWriter extends Writer {

	public UserWriter() {
		try {
			initWriter("Files/User.txt");
		} catch (Exception e) {
			LogUtil.getLogger().error(e);
		}
	}
	
	public void write(Product aProduct) {
		if (aProduct instanceof User) {
			writeUser((User) aProduct);
		}
	}

	private void writeUser(User aUser) {		
		String date = df.format(aUser.getBirthday().getTime());
		String s = "" + aUser.getUserId() + ";" + aUser.getName() + ";"
				+ aUser.getEmail() + ";" + aUser.getGender() + ";" + date + ";"
				+ aUser.getPassword() + ";" + aUser.getImage() + "\n";
		try {
			writer.write(s);
		} catch (IOException e) {
			LogUtil.getLogger().error(e);
		}
	}

}
