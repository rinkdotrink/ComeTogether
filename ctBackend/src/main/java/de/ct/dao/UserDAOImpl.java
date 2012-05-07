package de.ct.dao;

import com.google.inject.Inject;

import de.ct.db.UserPersistence;
import de.ct.db.UserPersistenceImpl;
import de.ct.shared.User;

public class UserDAOImpl implements UserDAO {

	private static long userId = 0;

	private UserPersistence db = new UserPersistenceImpl();

	public UserDAOImpl() {

	}

	@Inject
	public UserDAOImpl(UserPersistence userPersistence) {
		this.db = userPersistence;
	}

	@Override
	public User create() {
		User u = new User();
		u.setUserId(userId);
		userId++;
		return u;
	}

	@Override
	public User read(final long aUserId) {
		User user = db.read(aUserId);
		return user;
	}

	@Override
	public User update(final User aUser) {
		db.update(aUser);
		return aUser;
	}

	@Override
	public void delete(final User aUser) {
		db.delete(aUser);
	}

}
