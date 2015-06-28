package restapi;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("/order")
public class Order {

	@Path("/{Username}/{Amount}/{Tax}/{ShippingCost}/{addressid}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result order(@PathParam("Username") String username,@PathParam("Amount") float amount,@PathParam("Tax") int tax,@PathParam("ShippingCost") int shcost,@PathParam("addressid") int addid){
		model.Order order=new model.Order();
		model.Result result=new model.Result();
		order.setAmount(amount);
		order.setTax(tax);
		order.setShippingcost(shcost);
		order.setStatus(1);
		String add=dal.Address.getAddressById(addid);
		order.setAddress(add);
		result.setStatus(biz.Order.sendOrder(order, username));
		return result;
		
	}
	
	@Path("/{orderid}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Order getOrderedItems(@PathParam("orderid") int orderid){
		model.Order order=new model.Order();
		order=dal.Order.getOrderDetail(orderid);
		return order;
		
		
	}
}
