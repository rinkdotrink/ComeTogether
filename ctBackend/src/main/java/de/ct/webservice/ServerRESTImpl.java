package de.ct.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/ct")
public class ServerRESTImpl implements ServerREST {

	@GET
	@Produces("text/xml")
	public String halloWelt() {
		return "Hallo Welt!!";
	}
}
