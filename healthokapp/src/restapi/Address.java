package restapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Result;

@Path("/address")
public class Address {
	
	@Path("/{housenumber}/{street}/{city}/{state}/{country}/{pincode}/{username}/{fullname}/{phone}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result address(@PathParam("housenumber") String House,@PathParam("street") String Street,@PathParam("city") String City,@PathParam("state") String State,@PathParam("country") String Country,@PathParam("pincode") String Pincode,@PathParam("username") String Username,@PathParam("fullname") String full,@PathParam("phone") String ph){
	model.Address address=new model.Address();
	model.Result res=new model.Result();
	
	address.setHousenumber(House);
	address.setStreet(Street);
	address.setCity(City);
	address.setState(State);
	address.setCountry(Country);
	address.setPincode(Pincode);
	address.setFullname(full);
	address.setPhone(ph);
	 res.setStatus(biz.Address.sendAddress(address, Username));
	 return res;
		
	}
	//to return all address to display
	
	@Path("/{username}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static ArrayList<model.Address> getAddress(@PathParam("username") String user){
		ArrayList<model.Address> add=new ArrayList<model.Address>();
		add=biz.Address.getAddress(user);
		
		return add;
	}
	//to delete the address
	 @Path("/delete/{addressid}")
	 @GET
	 @Produces (MediaType.APPLICATION_JSON)
	public static void deleteAddress(@PathParam("addressid") int addid){
		biz.Address.deleteAddress(addid);
	}
	
	 //to update already exiting address
	 @Path("/update/{housenumber}/{street}/{city}/{state}/{country}/{pincode}/{addressid}/{fullname}/{phone}")
		@GET
		@Produces (MediaType.APPLICATION_JSON)
		public static void address(@PathParam("housenumber") String House,@PathParam("street") String Street,@PathParam("city") String City,@PathParam("state") String State,@PathParam("country") String Country,@PathParam("pincode") String Pincode,@PathParam("addressid") int addid,@PathParam("fullname") String full,@PathParam("phone") String ph){
		model.Address address=new model.Address();
		model.Result res=new model.Result();
		
		address.setHousenumber(House);
		address.setStreet(Street);
		address.setCity(City);
		address.setState(State);
		address.setCountry(Country);
		address.setPincode(Pincode);
		address.setFullname(full);
		address.setPhone(ph);
		biz.Address.updateAddress(address, addid);
		 
			
		}
	
}
