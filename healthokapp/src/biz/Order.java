package biz;

public class Order {

	public static int sendOrder(model.Order order, String username){
		
		return dal.Order.createOrder(order, username);
	}
}
