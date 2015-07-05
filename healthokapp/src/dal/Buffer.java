package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import servlet.Crudoperation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Buffer {
	//for return buffer array list to add in ordered items
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	//for add to buffer
	static Connection con1=null;
	static PreparedStatement ps1=null;
	//for delete from buffer
	static Connection con2=null;
	static PreparedStatement ps2=null;
	static ResultSet rs2=null;
	//for delete the whole cart of user after order
	static Connection con3=null;
	static PreparedStatement ps3=null;
	//update the quantity of midicine 
	static Connection con4=null;
	static PreparedStatement ps4=null;
	//get cart items
	static Connection con5=null;
	static PreparedStatement ps5=null;
	static ResultSet rs5=null;
	public static int addtoBuffer(String username,int medicineid,int quantity){
		
		int userid=0;
		int result=0;
		userid=dal.GetUserId.userid(username);
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str1="insert into buffer(quantity,UserId,medicineId) values (?,?,?)";
		try{
			ps1=(PreparedStatement) con.prepareStatement(str1);
			ps1.setInt(1, quantity);
			ps1.setInt(2, userid);
			ps1.setInt(3, medicineid);
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
		return result; 

	}
	
	public static int deleteBuffer(String username,int medicineid){
		int result=0;
		int userid=dal.GetUserId.userid(username);
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str2="delete from buffer where UserID=? and medicineId=?";
		try{
			ps2=(PreparedStatement) con.prepareStatement(str2);
			ps2.setInt(1, userid);
			ps2.setInt(2, medicineid);
			int rw=ps2.executeUpdate();
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
		return result;
		
	}
	//only for move to ordered items
	public static ArrayList<model.Buffer> getAllbufferItem(String username){
		int userid=0;
		ArrayList<model.Buffer> buffers=new ArrayList<>(); 
		
		userid=dal.GetUserId.userid(username);
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str="select * from buffer where UserId=?";
		try{
			ps=(PreparedStatement) con.prepareStatement(str); 
			ps.setInt(1,userid);
			rs=ps.executeQuery();
			while(rs.next()){
				int bufferid=rs.getInt("bufferId");
				int quantity=rs.getInt("quantity");
				int userId=rs.getInt("UserId");
				int medId=rs.getInt("medicineId");
				buffers.add(new model.Buffer(bufferid,quantity,userId,medId));
				
	       
			}
			
		}
		catch(SQLException se)
		   {
			   
		   }
		return buffers;
		 
	}
	
	public static void deleteBufferByid(String username){
		
		int result=0;
		int userid=dal.GetUserId.userid(username);
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str3="delete from buffer where UserID=? ";
		try{
			ps3=(PreparedStatement) con.prepareStatement(str3);
			ps3.setInt(1, userid);
			int rw=ps3.executeUpdate();
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
		
		//
	}
	
	public static int updateQuantity(String username,int medicineid,int quantity){
		int userid=dal.GetUserId.userid(username);
		int result=0;
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str4="update buffer set quantity=? where userid=? and medicineid=? ";
		try{
			ps4=(PreparedStatement) con.prepareStatement(str4);
			ps4.setInt(1, quantity);
			ps4.setInt(2, userid);
			ps4.setInt(3, medicineid);
			int rw=ps4.executeUpdate();
			if(rw>0)
			   {
				  result=1; 
			   }
			   else{
				   result=-1;
			   }
		}
		catch(SQLException se){
			
		}
		return result;
		
	}
	//to display cart items
	public static ArrayList<model.Medicine> getCartItems(String username){
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
			int id=rs5.getInt("medicineid");
			medicine.add( new model.Medicine(id,name, quant, price));
			
		}
		}
		catch(SQLException se)
		{
			
		}
		return medicine; 
	}
	
		
	}
	

