package de.ct.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sun.jersey.spi.resource.Singleton;

import de.ct.Module;
import de.ct.service.UserService;
import de.ct.shared.User;

@Singleton
@Path("/ctUser")
public class UserServerRESTImpl  implements UserServerREST {

	UserService userService;

	public UserServerRESTImpl() {
		Injector injector = Guice.createInjector(new Module());
		userService = injector.getInstance(UserService.class);
	}

	@POST
	@Path("/createUser")
	@Consumes("text/xml")
	public void User(User aUser) {
		User user = userService.createNewUser();
		user.setBirthday(aUser.getBirthday());
		user.setEmail(aUser.getEmail());
		user.setGender(aUser.getGender());
		user.setImage(aUser.getImage());
		user.setName(aUser.getName());
		user.setPassword(aUser.getPassword());
		
		userService.saveUser(user);
	}

	@POST
	@Path("/readUser")
	@Produces("text/xml")
	@Consumes("text/xml")
	public User User(String aUserId) {
		long userId = Long.parseLong(aUserId);
		User user = userService.findUserById(userId);
		return user;
	}

	@POST
	@Path("/deleteUser")
	@Consumes("text/xml")
	public void deleteUser(String aUserId) {
		long userId = Long.parseLong(aUserId);
		userService.deleteUser(userId);
	}

//	@GET
//	@Produces("text/xml")
//	public List<Message> Messages() {
//		List<Message> messages = messageService.getMessages();
//		return messages;
//	}

}
