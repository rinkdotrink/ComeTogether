package de.datagenerator.generator;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.datagenerator.creator.Creator;
import de.datagenerator.writer.IWriter;

public class UserGenerator extends Generator {

	private Random random = new Random(0);

	@Inject
	public UserGenerator(final Creator aCreator,
			final @Named("User") IWriter aDbWriter) {
		setCreator(aCreator);
		setDBWriter(aDbWriter);
	}

	@Override
	public final void generateUser(final long aUser) {
		long id;
		String name = "";
		String email = "";
		String gender = "";
		Calendar birthday;
		String password = "";
		String image = "";
		for (long i = 0; i < aUser; i++) {
			id = i;
			name = "User" + id;
			email = "E-Mail" + i + "@test.de";
			gender = computeGender();
			int int0_79 = computeIntBetween0and79();
			birthday = new GregorianCalendar(1940 + int0_79, 1, 1);
			password = "secret" + i;
			image = "c:\\Image" + i;
			setProduct(getCreator().createUser(id, name, email, gender,
					birthday, password, image));
			getDBWriter().write(getProduct());
		}
		getDBWriter().close();
	}

	private String computeGender() {
		String gender = "m";
		if (random.nextDouble() < 0.5) {
			gender = "w";
		} else {
			gender = "m";
		}
		return gender;
	}

	private int computeIntBetween0and79() {
		double randomDouble = random.nextDouble();
		int int0_100 = (int) Math.ceil(randomDouble * 100);
		int int0_79 = int0_100 % 80;
		return int0_79;
	}

}
