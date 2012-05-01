package de.ct.service;

import com.google.inject.Inject;

import de.ct.dao.UserDAO;
import de.ct.shared.User;

public class UserServiceImpl implements UserService {

	UserDAO userDAO;

	@Inject
	public UserServiceImpl(final UserDAO aUserDAO) {
		this.userDAO = aUserDAO;
	}

	@Override
	public User createNewUser() {
		return userDAO.create();
	}

	@Override
	public void deleteUser(final long aUserId) {
		User user;
		user = userDAO.read(aUserId);
		userDAO.delete(user);
	}

	@Override
	public User findUserById(final long aUserId) {
		return userDAO.read(aUserId);
	}

//	@Override
//	public List<User> getUsers() {
//		return userDAO.findAll();
//	}

	@Override
	public User saveUser(final User aUser) {
		return userDAO.update(aUser);
	}

}
