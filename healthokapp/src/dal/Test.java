package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import servlet.Crudoperation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class Test {
	static Connection con=null;
	static PreparedStatement ps5=null;
	static ResultSet rs5=null;
	
	static Connection con3;
	static PreparedStatement ps3=null;
	static ResultSet rs3=null;
	
	public static ArrayList<model.Medicine> testCartItems(String username){
		int userid=dal.GetUserId.userid(username);
		ArrayList<model.Medicine> medicine =new ArrayList<model.Medicine>();
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str1="SELECT * FROM healthok.buffer,healthok.medicine where healthok.buffer.userid=? and healthok.buffer.medicineid=healthok.medicine.medicineid";

		try{
		ps5=(PreparedStatement) con.prepareStatement(str1);
		ps5.setInt(1,userid);
		rs5=(ResultSet) ps5.executeQuery();
		while(rs5.next()){
			String name=rs5.getString("medicineName");
			int quant=rs5.getInt("buffer.quantity");
			float price=rs5.getFloat("price");
			medicine.add(new model.Medicine(name, quant, price));
			
		}
		}
		catch(SQLException se)
		{
			
		}
		
		return medicine;
	}
	
	public static ArrayList<model.Address> responseAddress(String username){
		int userid=dal.GetUserId.userid(username);
		ArrayList<model.Address> addresses=new ArrayList<model.Address>();
		
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
}
