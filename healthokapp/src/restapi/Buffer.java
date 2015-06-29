package restapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Result;

import org.glassfish.hk2.api.UseProxy;



@Path("/buffer")
public class Buffer {
	
	
	@Path("/{username}/{medicineid}/{quantity}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result getBuffer(@PathParam("username") String user,@PathParam("medicineid") int medicine,@PathParam("quantity") int quant){
		model.Result res=new model.Result();
		res.setStatus(biz.Buffer.sendtoBuffer(user, medicine, quant));
		return res;
		
	}
	@Path("/{username}/{medicineid}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result  delBuffer(@PathParam("username") String uname,@PathParam("medicineid") int medid){
		model.Result result=new model.Result();
		result.setStatus(biz.Buffer.sendDeleteBuffer(uname, medid));
		return result;
		
	}
	
	@Path("/change/{Username}/{Medicineid}/{Quantity}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result changeQuantity(@PathParam("Username") String username,@PathParam("Medicineid") int medicineid ,@PathParam("Quantity") int quantity){
		model.Result result=new model.Result();
		int res=dal.Buffer.updateQuantity(username, medicineid, quantity);
		result.setStatus(res);
		return result;
		
	}
	
	//to get all cart items
	@Path("/cart/{username}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static ArrayList<model.Medicine> getOrderedItems(@PathParam("username") String user){
		ArrayList<model.Medicine> medicine =new ArrayList<model.Medicine>();
		medicine=biz.Buffer.getCartItems(user);
		return medicine;
		
		
	}

}
