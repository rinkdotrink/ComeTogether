package de.datagenerator.generator.unittest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UserGeneratorTest.class, EventGeneratorTest.class, MessageGeneratorTest.class, ParticipationGeneratorTest.class})
public class AllTests {

}
