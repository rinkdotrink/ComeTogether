package de.ct.service;

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

public class UserServiceImplTest {

	UserService userService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new Module());
		userService = injector.getInstance(UserService.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateNewMessage() {
		assertNotNull(userService.createNewUser());
	}

	@Test
	public void testDeleteUser() {
		User user = userService.createNewUser();
		userService.deleteUser(user.getId());
		User u1 = null;

		u1 = userService.findUserById(user.getId());
		assertNull(u1);
	}

	@Test
	public void testFindUserById() {
		User user = userService.createNewUser();
		boolean userFound = false;

		if (userService.findUserById(user.getId()) != null) {
			userFound = true;
		}
		assertTrue(userFound);
	}

	@Test
	public void testGetUsers() {
		assertNotNull(userService.getUsers());
	}

	@Test
	public void testSaveUser() {
		User u = userService.createNewUser();
		u.setName("Hallo");
		userService.saveUser(u);
		User userFound = null;
		userFound = userService.findUserById(u.getId());
		assertTrue(userFound.getName().equalsIgnoreCase("Hallo"));
	}

}
