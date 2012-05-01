package de.ct.datamodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.Module;
import de.ct.shared.User;

public class UserTest {
	User user;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new Module());
		user = injector.getInstance(User.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetId() {
		user.setUserId(1);
		assertEquals(1, user.getUserId());
	}

	@Test
	public void testSetId() {
		user.setUserId(1);
		assertEquals(1, user.getUserId());
	}

	@Test
	public void testGetName() {
		user.setName("name1");
		assertTrue(user.getName().equalsIgnoreCase("name1"));
	}

	@Test
	public void testSetName() {
		user.setName("name1");
		assertTrue(user.getName().equalsIgnoreCase("name1"));
	}

	@Test
	public void testGetEmail() {
		user.setEmail("email");
		assertTrue(user.getEmail().equalsIgnoreCase("email"));
	}

	@Test
	public void testSetEmail() {
		user.setEmail("email");
		assertTrue(user.getEmail().equalsIgnoreCase("email"));
	}

	@Test
	public void testGetGender() {
		user.setGender("m");
		assertTrue(user.getGender().equalsIgnoreCase("m"));
	}

	@Test
	public void testSetGender() {
		user.setGender("m");
		assertTrue(user.getGender().equalsIgnoreCase("m"));
	}

	@Test
	public void testGetBirthday() {
		user.setBirthday(new GregorianCalendar(2000, 7, 1));
		assertEquals(new GregorianCalendar(2000, 7, 1), user.getBirthday());
	}

	@Test
	public void testSetBirthday() {
		user.setBirthday(new GregorianCalendar(2000, 7, 1));
		assertEquals(new GregorianCalendar(2000, 7, 1), user.getBirthday());
	}

	@Test
	public void testGetPassword() {
		user.setPassword("geheim");
		assertTrue(user.getPassword().equalsIgnoreCase("geheim"));
	}

	@Test
	public void testSetPassword() {
		user.setPassword("geheim");
		assertTrue(user.getPassword().equalsIgnoreCase("geheim"));
	}

	@Test
	public void testGetImage() {
		
		user.setImage("Bild");
		assertEquals("Bild", user.getImage());
	}

	@Test
	public void testSetImage() {
		
		user.setImage("Bild");
		assertEquals("Bild", user.getImage());
	}

	@Test
	public void testHashCode() {
		user.setUserId(1);
		assertEquals(1, user.hashCode());
	}

	@Test
	public void testEquals() {
		User userTemp = new User();
		userTemp.setUserId(1);
		user.setUserId(1);
		assertTrue(user.equals(userTemp));
	}

}
