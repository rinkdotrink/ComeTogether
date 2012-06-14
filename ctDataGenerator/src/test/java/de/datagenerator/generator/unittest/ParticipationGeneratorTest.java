package de.datagenerator.generator.unittest;

import static org.easymock.EasyMock.createControl;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.shared.Participation;
import de.ct.shared.Product;
import de.datagenerator.DBModule;
import de.datagenerator.creator.Creator;
import de.datagenerator.generator.ParticipationGenerator;
import de.datagenerator.writer.IWriter;
import de.datagenerator.writer.ParticipationWriter;

public class ParticipationGeneratorTest {

	private ParticipationGenerator classUnderTest;
	private IWriter mock;
	private Injector injector = Guice.createInjector(new DBModule());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		IMocksControl mockControl = createControl();
		mock = mockControl.createMock(ParticipationWriter.class);
		Creator creator = injector.getInstance(Creator.class);
		classUnderTest = new ParticipationGenerator(creator, mock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGenerateParticipation_0() {
		long user = 0;
		long participationPerUser = 0;
		long eventPerUser = 0;

		mock.close();
		replay(mock);
		classUnderTest.generateParticipation(participationPerUser, user,
				eventPerUser);
		verify(mock);
	}

	@Test
	public final void testGenerateParticipation_1() {
		long user = 1;
		long participationPerUser = 1;
		long eventPerUser = 1;

		Product participation0 = new Participation(0, 0, 0);
		mock.write(participation0);
		mock.close();
		replay(mock);
		classUnderTest.generateParticipation(participationPerUser, user, eventPerUser);
		verify(mock);
	}

	@Test
	public final void testGenerateParticipation_2() {
		long user = 1;
		long participationPerUser = 2;
		long eventPerUser = 1;

		Product participation0 = new Participation(0, 0, 0);
		Product participation1 = new Participation(1, 0, 0);
		
		mock.write(participation0);
		mock.write(participation1);
		
		mock.close();
		replay(mock);
		classUnderTest.generateParticipation(participationPerUser, user, eventPerUser);
		verify(mock);
	}
	
	@Test
	public final void testGenerateParticipation_3() {
		long user = 2;
		long participationPerUser = 2;
		long eventPerUser = 2;

		Product participation0 = new Participation(0, 0, 0);
		Product participation1 = new Participation(1, 1, 1);
		Product participation2 = new Participation(2, 0, 2);
		Product participation3 = new Participation(3, 1, 3);
		
		mock.write(participation0);
		mock.write(participation1);
		mock.write(participation2);
		mock.write(participation3);
		
		mock.close();
		replay(mock);
		classUnderTest.generateParticipation(participationPerUser, user, eventPerUser);
		verify(mock);
	}
}
