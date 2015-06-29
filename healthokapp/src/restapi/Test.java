package restapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/create")
public class Test {
	@Path("/1")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public model.Medicine create(model.Medicine med){
	   
		return med;
	}

	@Path("/2")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String test(model.Medicine med){
	   
		return med.getMedicineName();
	}
	
	@Path("/4")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String test1(model.Medicine med){
	   
		return med.getMedicineName();
	}

	@Path("/{username}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static ArrayList<model.Medicine> getOrderedItems(@PathParam("username") String user){
		ArrayList<model.Medicine> medicine =new ArrayList<model.Medicine>();
		medicine=dal.Test.testCartItems(user);
		return medicine;
		
		
	}
	@Path("/address/{username}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static ArrayList<model.Address> getAddress(@PathParam("username") String user){
		ArrayList<model.Address> address =new ArrayList<model.Address>();
		address=dal.Test.responseAddress(user);
		return address;
		
		
	}
}
