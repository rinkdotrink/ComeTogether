package de.ct.service;

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

import de.ct.dao.UserDAO;
import de.ct.shared.User;

public class UserServiceImplUnittest {

	private UserService classUnderTest;
	private UserDAO mock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		IMocksControl mockControl = createControl();
		mock = mockControl.createMock(UserDAO.class);
		classUnderTest = new UserServiceImpl(mock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateNewUser() {
		User user = new User();
		user.setUserId(0);		
		EasyMock.expect(classUnderTest.createNewUser()).andReturn(user).times(1);
		EasyMock.replay(mock);
		User u = classUnderTest.createNewUser();
		assertEquals(user, u);
		verify(mock);
	}

	@Test
	public void testDeleteUser() {
		User user = new User();
		user.setUserId(0);
		EasyMock.expect(mock.read(0)).andReturn(user);
		mock.delete(user);
		EasyMock.replay(mock);		
		classUnderTest.deleteUser(0);		
		verify(mock);
	}

	@Test
	public void testFindEventById() {
		User user = new User();
		user.setUserId(0);
		EasyMock.expect(mock.read(0)).andReturn(user).times(1);
		EasyMock.replay(mock);		
		classUnderTest.findUserById(0);		
		verify(mock);
	}
	
	
	@Test
	public void testSaveEvent() {
		User user = new User();
		user.setUserId(0);
		EasyMock.expect(mock.update(user)).andReturn(user).times(1);
		EasyMock.replay(mock);		
		User u2 = classUnderTest.saveUser(user);		
		verify(mock);
		assertEquals(user, u2);
	}

}
