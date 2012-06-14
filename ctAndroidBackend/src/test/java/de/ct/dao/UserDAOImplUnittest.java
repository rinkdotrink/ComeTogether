package de.ct.dao;

import static org.easymock.EasyMock.createControl;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.ct.db.UserPersistence;
import de.ct.shared.User;

public class UserDAOImplUnittest {

	private UserDAO classUnderTest;
	private UserPersistence mock;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		IMocksControl mockControl = createControl();
		mock = mockControl.createMock(UserPersistence.class);
		classUnderTest = new UserDAOImpl(mock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		User user = new User();
		user.setUserId(0);
		User u2 = classUnderTest.create();
		assertEquals(user, u2);
	}

	@Test
	public void testRead() {
		User user = new User();
		user.setUserId(0);
		EasyMock.expect(classUnderTest.read(0)).andReturn(user).times(1);
		EasyMock.replay(mock);
		User u2 = classUnderTest.read(0);
		assertEquals(user, u2);
		verify(mock);
	}

	@Test
	public void testUpdate() {
		User user = new User();
		EasyMock.expect(classUnderTest.update(user)).times(1);
		EasyMock.replay(mock);
		User u2 = classUnderTest.update(user);
		assertEquals(user, u2);
		verify(mock);
	}

	@Test
	public void testDelete() {
		User user = new User();
		user.setUserId(0);
		mock.delete(user);
		EasyMock.replay(mock);		
		classUnderTest.delete(user);		
		verify(mock);
	}

}
