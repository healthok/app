package dal;


import java.sql.*;

import model.Result;
import servlet.Crudoperation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;




public class User {
	
	static Connection con=null;
	static PreparedStatement ps=null;
  static ResultSet rs=null;
  

	public static int Save (model.User user)
	{
		int result=-1;
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
	   String str="insert into User(emailid,firstName,phone,password,lastName) values (?,?,?,?,?)";
	   try
	   {
		   ps=(PreparedStatement) con.prepareStatement(str);
		   ps.setString(1,user.getEmailId());
		   ps.setString(2,user.getFirstName());
		   ps.setString(3,user.getPhone());
		   ps.setString(4,user.getPassword());
		   ps.setString(5,user.getLastName());
		   int rw=ps.executeUpdate();
		   if(rw>0)
		   {
			  result=1; 
		   }
		   
	   }
	   catch(SQLException se)
	   {
		   
	   }
	return result;
	}
	
	

	public static int ValidateCredentials(String username,String password){
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		int result=0;
		String str="select * from user where emailid=? and password=?";
		try
		{
			ps=(PreparedStatement) con.prepareStatement(str); 
			ps.setString(1,username);
			ps.setString(2,password);
			rs=ps.executeQuery();
			if(rs.next())
			{
				result=1;
			}
			else
			{
				result=-1;
			}
		}
		catch(SQLException se)
		{
			
		}
		return result;
		
	}
}
