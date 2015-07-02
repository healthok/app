package restapi;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
	@Path("/personal")
public class Personalinfo {
	
	
	@Path("/allorder/{username}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static ArrayList<model.Order> getOrderedItems(@PathParam("username") String user){
		ArrayList<model.Order> orders =new ArrayList<model.Order>();
		orders=dal.Personalinfo.getAllOrderDetail(user);
		return orders;
		
		
	}

}
