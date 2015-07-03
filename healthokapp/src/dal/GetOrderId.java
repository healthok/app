package dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import servlet.Crudoperation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GetOrderId {
	
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	public static int getRecentOrderid(String username){
		int userid=0;
		int orderid=0;
		userid=dal.GetUserId.userid(username);
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str="select max(orderid) from healthok.order where UserId=?";
		try{
			ps=(PreparedStatement) con.prepareStatement(str); 
			ps.setInt(1,userid);
			rs=ps.executeQuery();
			if(rs.next()){
	        orderid=rs.getInt(1);
	        
			}
			
		}
		catch(SQLException se)
		   {
			   
		   }
		
		return orderid; 
		
		
	}
}
