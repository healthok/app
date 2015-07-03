package dal;

import java.sql.SQLException;

import servlet.Crudoperation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Order {
	
	static Connection con=null;
	static PreparedStatement ps1=null;
	//
	static Connection con2=null;
	static PreparedStatement ps2=null;
	static ResultSet rs2=null;
	public static int createOrder(model.Order order,String username){
		int userid=0;
		int result=0;
		java.util.Date dt=new java.util.Date();
		java.sql.Date sd=new java.sql.Date(dt.getDate());
		userid=dal.GetUserId.userid(username);
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str="insert into healthok.order (amount,status,Tax,ShippingCost,UserId,Address,Date) values (?,?,?,?,?,?,?)";
		
		try{
			ps1=(PreparedStatement) con.prepareStatement(str);
			ps1.setFloat(1, order.getAmount());
			ps1.setInt(2, order.getStatus());
			ps1.setInt(3, order.getTax());
			ps1.setInt(4, order.getShippingcost());
			ps1.setInt(5, userid);
			ps1.setString(6, order.getAddress()); 
			ps1.setDate(7, sd);
			int rw=ps1.executeUpdate();
			
			if(rw>0)
			   {
				  result=1; 
			   }
			   else{
				   result=-1;
			   }
		}
		catch(SQLException se)
		{
			
		}
		biz.OrderedItems.addItems(username);
		dal.Buffer.deleteBufferByid(username);
		 result=dal.GetOrderId.getRecentOrderid(username);
		return result;
	}
	
	public static model.Order getOrderDetail(int orderid){
		model.Order order=new model.Order();
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str1="select * from healthok.order where orderId=?";
		try{
			ps2=(PreparedStatement) con.prepareStatement(str1);
			ps2.setInt(1,orderid);
			rs2=(ResultSet) ps2.executeQuery();
			if(rs2.next()){
				order.setAddress( rs2.getString("Address"));
				order.setAmount(rs2.getFloat("amount"));
				order.setOrderId(rs2.getInt("orderid"));
				order.setShippingcost(rs2.getInt("ShippingCost"));
				order.setStatus(rs2.getInt("status"));
				order.setTax(rs2.getInt("tax"));
				order.setUserid(rs2.getInt("userid"));
			}
		}
		catch(SQLException se)
		{
			
		}
		return order;
	}

}
