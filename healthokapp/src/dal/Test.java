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
	static Connection con5=null;
	static PreparedStatement ps5=null;
	static ResultSet rs5=null;
	
	public static ArrayList<model.Medicine> testCartItems(String username){
		int userid=dal.GetUserId.userid(username);
		ArrayList<model.Medicine> medicine =new ArrayList<model.Medicine>();
		con5=(Connection) Crudoperation.createConnection();
		String str1="SELECT * FROM healthok.buffer,healthok.medicine where healthok.buffer.userid=? and healthok.buffer.medicineid=healthok.medicine.medicineid";

		try{
		ps5=(PreparedStatement) con5.prepareStatement(str1);
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
	
	
}
