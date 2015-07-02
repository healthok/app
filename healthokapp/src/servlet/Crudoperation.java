package servlet;
import java.sql.*;

import javax.naming.InitialContext;

import com.owlike.genson.Context;
public class Crudoperation 
{
private static Connection Con=null; 
ResultSet rs=null;
PreparedStatement ps=null;
Context env = (Context)new InitialContext().lookup("java:comp/env");

String connection = (String)env.lookup("connection");
public static Connection createConnection()
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/healthok","root","root");
	}
	catch(SQLException se)
	{
		System.out.println(se);
	}
	catch(ClassNotFoundException cnf)
	{
		System.out.println(cnf);
	}
	return Con;
}
}