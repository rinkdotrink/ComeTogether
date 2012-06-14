package de.datagenerator.generator.unittest;

import static org.easymock.EasyMock.createControl;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.GregorianCalendar;

import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.shared.Product;
import de.ct.shared.User;
import de.datagenerator.DBModule;
import de.datagenerator.creator.Creator;
import de.datagenerator.generator.UserGenerator;
import de.datagenerator.writer.IWriter;
import de.datagenerator.writer.UserWriter;

public class UserGeneratorTest {

   private UserGenerator classUnderTest;
   private IWriter mock;
   private Injector injector = Guice.createInjector(new DBModule());

   @BeforeClass
   public static void setUpBeforeClass()
      throws Exception {
   }

   @AfterClass
   public static void tearDownAfterClass()
      throws Exception {
   }

   @Before
   public void setUp()
      throws Exception {
      IMocksControl mockControl = createControl();
      mock = mockControl.createMock(UserWriter.class);
      Creator creator = injector.getInstance(Creator.class);
      classUnderTest = new UserGenerator(creator, mock);
   }

   @After
   public void tearDown()
      throws Exception {
   }

   @Test
   public final void testGenerateUser_0() {
      long user = 0;

      mock.close();
      replay(mock);
      classUnderTest.generateUser(user);
      verify(mock);
   }

   @Test
   public final void testGenerateUser_1() {
      long user = 1;

      Product user0 = new User(0, "User0", "E-Mail0", "w", new GregorianCalendar(1990, 01, 01), "secret", "c:\\Image0");
      mock.write(user0);
      mock.close();
      replay(mock);
      classUnderTest.generateUser(user);
      verify(mock);
   }

   @Test
   public final void testGenerateKunden_4() {
      long user = 4;

      Product user0 = new User(0, "User0", "E-Mail0", "w", new GregorianCalendar(1990, 01, 01), "secret", "c:\\Image0");
      Product user1 = new User(1, "User1", "E-Mail1", "w", new GregorianCalendar(1990, 01, 01), "secret", "c:\\Image1");
      Product user2 = new User(2, "User2", "E-Mail2", "w", new GregorianCalendar(1990, 01, 01), "secret", "c:\\Image2");
      Product user3 = new User(3, "User3", "E-Mail3", "w", new GregorianCalendar(1990, 01, 01), "secret", "c:\\Image3");

      mock.write(user0);
      mock.write(user1);
      mock.write(user2);
      mock.write(user3);
      mock.close();

      replay(mock);
      classUnderTest.generateUser(user);
      verify(mock);
   }

   @Test
   public final void testGenerateKunden_5() {
      long user = 5;

      Product user0 = new User(0, "User0", "E-Mail0", "w", new GregorianCalendar(1990, 01, 01), "secret", "c:\\Image0");
      Product user1 = new User(1, "User1", "E-Mail1", "w", new GregorianCalendar(1990, 01, 01), "secret", "c:\\Image1");
      Product user2 = new User(2, "User2", "E-Mail2", "w", new GregorianCalendar(1990, 01, 01), "secret", "c:\\Image2");
      Product user3 = new User(3, "User3", "E-Mail3", "w", new GregorianCalendar(1990, 01, 01), "secret", "c:\\Image3");
      Product user4 = new User(4, "User4", "E-Mail4", "w", new GregorianCalendar(1990, 01, 01), "secret", "c:\\Image4");

      mock.write(user0);
      mock.write(user1);
      mock.write(user2);
      mock.write(user3);
      mock.write(user4);
      mock.close();

      replay(mock);
      classUnderTest.generateUser(user);
      verify(mock);
   }

}
