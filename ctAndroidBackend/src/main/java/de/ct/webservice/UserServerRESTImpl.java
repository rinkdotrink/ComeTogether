package de.ct.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ct.Module;
import de.ct.helper.Marshaller;
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
	@Consumes("text/plain")	
	@Produces("application/json")
	public User User1(String aUserStr) {
		Marshaller marshaller = new Marshaller();
		User aUser = (User) marshaller.unmarshall(aUserStr, new User());		
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
	@Consumes("text/plain")
	@Produces("application/json")	
	public User User2(String aUserId) {
		long userId = Long.parseLong(aUserId);
		User user = userService.findUserById(userId);		
		return user;
	}
	

	@POST
	@Path("/login")
	@Consumes("text/plain")
	@Produces("application/json")	
	public User User3(String aUserStr) {
		Marshaller marshaller = new Marshaller();
		User user = (User) marshaller.unmarshall(aUserStr, new User());
		User user2 = userService.findUserByName(user.getName());
		User userReturn = null;
		if(user2.getPassword().equalsIgnoreCase(user.getPassword())) {
			userReturn = user;
		}
		return userReturn;
	}


	@POST
	@Path("/deleteUser")
	@Consumes("text/plain")
	@Produces("text/plain")
	public String deleteUser(String aUserId) {
		long userId = Long.parseLong(aUserId);
		userService.deleteUser(userId);
		String result = "User deleted: " + userId;
		return result;
	}


	// @GET
	// @Produces("text/xml")
	// public List<Message> Messages() {
	// List<Message> messages = messageService.getMessages();
	// return messages;
	// }

}
