package dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import servlet.Crudoperation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GetAddressId {
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	public static int getRecentAddressid(String username){
		int userid=0;
		int addressid=0;
		userid=dal.GetUserId.userid(username);
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str="select max(AddressId) from address where UserId=?";
		try{
			ps=(PreparedStatement) con.prepareStatement(str); 
			ps.setInt(1,userid);
			rs=ps.executeQuery();
			if(rs.next()){
	        addressid=rs.getInt(1);
	        
			}
			
		}
		catch(SQLException se)
		   {
			   
		   }
		
		return addressid;
		
		
	}

}
