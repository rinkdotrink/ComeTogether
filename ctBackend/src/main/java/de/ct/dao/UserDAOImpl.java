package de.ct.dao;

import java.util.ArrayList;
import java.util.List;

import de.ct.shared.User;

public class UserDAOImpl implements UserDAO {

	private List<User> users = new ArrayList<User>();
	private static long userId = 0;

	@Override
	public User create() {
		User u = new User();
		userId++;
		u.setId(userId);
		users.add(u);
		return u;
	}

	@Override
	public User read(final long aUserId) {
		User temp = findUser(aUserId);
		return temp;
	}

	@Override
	public User update(final User aUser) {
		User temp = findUser(aUser.getId());
		copyAttributes(temp, aUser);
		return temp;
	}

	@Override
	public void delete(final User aUser) {
		users.remove(aUser);
	}

	@Override
	public List<User> findAll() {
		return users;
	}

	private void copyAttributes(final User aTemp, final User aUser) {
		aTemp.setId(aUser.getId());
		aTemp.setBirthday(aUser.getBirthday());
		aTemp.setEmail(aUser.getEmail());
		aTemp.setGender(aUser.getGender());
		aTemp.setImage(aUser.getImage());
		aTemp.setName(aUser.getName());
		aTemp.setPassword(aUser.getPassword());
		
	}

	private User findUser(final long aUserId) {
		User temp = null;
		for (User m : users) {
			if (m.getId() == aUserId) {
				temp = m;
			}
		}
		return temp;
	}

}
