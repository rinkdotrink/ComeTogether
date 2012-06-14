package de.datagenerator.generator;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.datagenerator.creator.Creator;
import de.datagenerator.writer.IWriter;

public class UserGenerator extends Generator {

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
			email = "E-Mail" + i;
			gender = "w";
			birthday = new GregorianCalendar(1990, 1, 1);
			password = "secret";
			image = "c:\\Image" + i;
			
			setProduct(getCreator().createUser(id, name, email, gender, birthday, password, image));
			getDBWriter().write(getProduct());
		}
		getDBWriter().close();
	}

}
