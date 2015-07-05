package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import servlet.Crudoperation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Medicine {
	static Connection con=null;
	static PreparedStatement ps=null;
  static ResultSet rs=null;
  static Connection con1=null;
	static PreparedStatement ps1=null;
static ResultSet rs1=null;
	
	
	
	public static model.Medicine sendMedicine(String name){
		
		Crudoperation crudoperation = new Crudoperation();
		con =(Connection) crudoperation.createConnection();
		model.Medicine medicine=new model.Medicine();
		String str="select * from medicine where medicineName=?";
		try
		{
			ps=(PreparedStatement) con.prepareStatement(str); 
			ps.setString(1,name);
			rs=ps.executeQuery();
			if(rs.next())
			{
				medicine.setMedicineId(rs.getInt("medicineId"));
				medicine.setMedicineName(rs.getString("medicinename"));
				medicine.setComposition(rs.getString("composition"));
				medicine.setDosage(rs.getString("dosage"));
				medicine.setCompany(rs.getString("company"));
				medicine.setQuantity(rs.getInt("quantity"));
				medicine.setPrice(rs.getFloat("price"));
			}
			else
			{
				medicine=null;
			}
		}
		 catch(SQLException se)
		   {
			   
		   } 
		return medicine;
	}
	
	public static Map<Long,String> searchMedicine(String medicinename ){
		Map<Long, String> medilist=new HashMap<>();
		long i=1;
		String data;
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str="select * from medicine where medicineName like ?";
		try{
			ps1=(PreparedStatement) con.prepareStatement(str); 
			ps1.setString(1,medicinename+"%");
			rs1=ps1.executeQuery();
			while(rs1.next()){
				data=rs1.getString("medicineName");
				medilist.put(i,data);
				i++;
			}
			
		}
		catch(SQLException se)
		{
				
		}
		
	
		return medilist;
	}

}
