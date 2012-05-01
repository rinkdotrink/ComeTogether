package de.ct.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.Module;
import de.ct.shared.User;

public class UserDAOImplTest {

	UserDAO userDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new Module());
		userDAO = injector.getInstance(UserDAO.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		User u = userDAO.create();
		assertNotNull(u);
	}

	@Test
	public void testRead() {
		User u = userDAO.create();		
		userDAO.update(u);
		User u2 = null;		
		u2 = userDAO.read(u.getUserId());

		assertNotNull(u2);
	}

	@Test
	public void testUpdate() {
		User user = userDAO.create();
		user.setName("Name1");
		long userId = user.getUserId();
		userDAO.update(user);
		boolean userUpdated = false;

		userUpdated = userDAO.read(userId).getName()
				.equalsIgnoreCase("Name1");

		assertTrue(userUpdated);
	}

	@Test
	public void testDelete() {
		User user = userDAO.create();
		long userId = user.getUserId();
		userDAO.delete(user);
		User u2 = null;
		u2 = userDAO.read(userId);

		assertNull(u2);
	}

}
