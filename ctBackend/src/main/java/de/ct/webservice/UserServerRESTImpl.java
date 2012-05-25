package de.ct.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.Module;
import de.ct.service.UserService;
import de.ct.shared.User;

@Path("/ctUser")
public class UserServerRESTImpl implements UserServerREST {

	UserService userService;

	public UserServerRESTImpl() {
		Injector injector = Guice.createInjector(new Module());
		userService = injector.getInstance(UserService.class);
	}

	@POST
	@Path("/createUser")
	@Consumes("application/json")
	@Produces("application/json")
	public User User(User aUser) {
		User user = userService.createNewUser();
		user.setBirthday(aUser.getBirthday());
		user.setEmail(aUser.getEmail());
		user.setGender(aUser.getGender());
		user.setImage(aUser.getImage());
		user.setName(aUser.getName());
		user.setPassword(aUser.getPassword());
		User user2 = userService.saveUser(user);
		return user2;
	}

	@POST
	@Path("/readUser")
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded")
	public User User(String aUserId) {
		String id = aUserId.substring(7, 8);
		long userId = Long.parseLong(id);
		User user = userService.findUserById(userId);
		return user;
	}

	@POST
	@Path("/deleteUser")
	@Consumes("application/x-www-form-urlencoded")
	public Response deleteUser(String aUserId) {
		String id = aUserId.substring(7, 8);
		long userId = Long.parseLong(id);
		userService.deleteUser(userId);
		String result = "User deleted: " + userId;
		return Response.status(201).entity(result).build();
	}

	// @GET
	// @Produces("text/xml")
	// public List<Message> Messages() {
	// List<Message> messages = messageService.getMessages();
	// return messages;
	// }

}
