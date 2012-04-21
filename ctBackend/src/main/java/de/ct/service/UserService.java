package de.ct.service;

import java.util.List;

import de.ct.shared.User;

public interface UserService {

	public User createNewUser();

	public void deleteUser(final long aUserId);

	public User findUserById(final long aUserId);

	public List<User> getUsers();

	public User saveUser(final User aUser);
}
