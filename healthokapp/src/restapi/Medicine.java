package restapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/medicine")
public class Medicine {
	
	
	@Path("/{medicinename}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Medicine returnMedicin( @PathParam("medicinename") String name){
		
		model.Medicine result=new model.Medicine();
		result=dal.Medicine.sendMedicine(name);
		return result;
	}

	@Path("/max/{medicine}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static Map<Long,String> allMedicin( @PathParam("medicine") String name){
		Map<Long, String> medilis=new HashMap<>();
		medilis =dal.Medicine.searchMedicine(name);
		return medilis;
	}
	

}
