package restapi;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.collections.map.HashedMap;


@Path("/orderitems")
public class OrderedItems {
	@Path("/{orderid}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static Map<Long, model.Medicine> getOrderedItems(@PathParam("orderid") int orderid){
		Map<Long, model.Medicine> medicine=new HashMap<>();
		medicine=dal.OrderedItems.getOrderItems(orderid);
		return medicine;
		
		
	}

}
