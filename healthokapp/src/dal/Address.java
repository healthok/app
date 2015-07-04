package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import servlet.Crudoperation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Address {
//for insert address
	static Connection con=null;
	static PreparedStatement ps=null;
	//to delete address
	static PreparedStatement ps1=null;
	static Connection con1=null;
	static ResultSet rs=null;
//for single address by id in string format
  	static Connection con2=null;
	static PreparedStatement ps2=null;
	static ResultSet rs2=null;
	//for response address all 
		static Connection con3;
		static PreparedStatement ps3=null;
		static ResultSet rs3=null;
		//update address
		static Connection con4=null;
		static PreparedStatement ps4=null;

	public static int insertAddress(model.Address address, String username){
		int result=0;
		int userid=dal.GetUserId.userid(username);
		address.setUserId(userid);
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str1="insert into address(housenumber,street,city,state,country,pincode,userid,fullname,phone) values (?,?,?,?,?,?,?,?,?)";
		try{
			 ps=(PreparedStatement) con.prepareStatement(str1);
			   ps.setString(1,address.getHousenumber());
			   ps.setString(2, address.getStreet());
			   ps.setString(3, address.getCity());
			   ps.setString(4, address.getState());
			   ps.setString(5, address.getCountry());
			   ps.setString(6, address.getPincode());
			   ps.setInt(7, address.getUserId());
			   ps.setString(8, address.getFullname());
			   ps.setString(9, address.getPhone());
			   
			   int rw=ps.executeUpdate();
			  
			   if(rw>0)
			   {
				  result=dal.GetAddressId.getRecentAddressid(username);
			   }
			   else{
				   result=-1;
			   }
		}
		catch(SQLException se)
		   {
			   
		   }
		return result; 
	}
	
	public static ArrayList<model.Address> responseAddress(String username){
		model.Address address1=new model.Address();
		int userid=dal.GetUserId.userid(username);
		ArrayList<model.Address> addresses=new ArrayList<model.Address>();
		long i=1;
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str3="select * from address where UserId=?";
		try{
			ps3=(PreparedStatement) con.prepareStatement(str3); 
			ps3.setInt(1,userid);
			rs3=ps3.executeQuery();
			while(rs3.next()){
	        int user=rs3.getInt("UserId");
	        String house=rs3.getString("housenumber");
	        String street=rs3.getString("Street");
	       String city=rs3.getString("City");
	        String state=rs3.getString("State");
	        String country=rs3.getString("Country");
	       String pin=rs3.getString("pincode");
	        int addid=rs3.getInt("AddressId");
	        String fname=rs3.getString("fullname");
	        String phone=rs3.getString("phone");
	        addresses.add(new model.Address(house, street, city, state, country, pin, addid, user, fname, phone));
	        
			}
			
		}
		catch(SQLException se)
		   {
			   
		   }
		return addresses; 
	}
	//get address by id in string format to insert in order table
	public static String getAddressById(int addressid){
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str="select * from Address where AddressId=?";
		String address="";
		try{
			ps2=(PreparedStatement) con.prepareStatement(str); 
			ps2.setInt(1,addressid);
			rs2=ps2.executeQuery();
			if(rs2.next()){
			address=rs2.getString("fullname")+","+rs2.getString("housenumber")+","+rs2.getString("Street")+","+rs2.getString("City")+","+rs2.getString("State")+","+rs2.getString("Country")+","+rs2.getString("pincode")+",Phone no. "+rs2.getString("phone");    
	      
				
			}
			
		}
		catch(SQLException se)
		   {
			   
		   }
		return address; 
		
	}
	public static void deleteAddress(int addressid){
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str2="delete from address where addressid=?";
		try{
			ps1=(PreparedStatement) con.prepareStatement(str2);
			ps1.setInt(1, addressid);
			int rw=ps1.executeUpdate();
		}
		catch(SQLException se){
			
		}
	}
	
	 public static void updateAddress(model.Address address,int addressid){
			Crudoperation crudoperation = new Crudoperation();
			con=(Connection) crudoperation.createConnection();
		 String str4="update address set housenumber=?,street=?,City=?,State=?,Country=?,pincode=?,fullname=?,phone=? where Addressid=?";
		 try{
			 ps4=(PreparedStatement) con.prepareStatement(str4);
			 ps4.setString(1, address.getHousenumber());
			 ps4.setString(2, address.getStreet());
			 ps4.setString(3, address.getCity());
			 ps4.setString(4, address.getState());
			 ps4.setString(5, address.getCountry());
			 ps4.setString(6, address.getPincode());
			 ps4.setString(7, address.getFullname());
			 ps4.setString(8, address.getPhone());
			 ps4.setInt(9, addressid);
			 int rw=ps4.executeUpdate();
		 }
		 catch(SQLException se)
		 {
			 
		 }
	 }
	
}
