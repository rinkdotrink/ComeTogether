package de.ct.dao;

import java.util.List;

import de.ct.shared.User;

public interface UserDAO {

	public User create();

	public User read(final long aUserId);

	public User update(final User aUser);

	public void delete(final User aUser);

	public List<User> findAll();
}
