package restapi;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Result;

@Path("/signup/{FirstName}/{LastName}/{emailId}/{password}/{phone}")
public class User {
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result signUp(@PathParam("FirstName") String Fname, @PathParam("LastName") String Lname,@PathParam("emailId") String email, @PathParam("password") String pass,@PathParam("phone") String phone)
	{
		model.Result re=new model.Result();
		int result;
		model.User user=new model.User();
		user.setFirstName(Fname);
		user.setLastName(Lname);
		user.setEmailId(email);
		user.setPassword(pass);
		user.setPhone(phone);
		result= biz.User.Save(user);
		re.setStatus(result);
		return re;
		
		
	}

}
