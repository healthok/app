package servlet;
import java.sql.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

public class Crudoperation 
{
private static Connection Con=null; 

@Context
ServletContext context;

ResultSet rs=null;
PreparedStatement ps=null;

public  Connection createConnection()
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		String host="localhost";
		String port ="3306";
		String dbname = "healthok";
		String username = "root";
		String password = "root";
				
		
		//Context env = (Context) new InitialContext().lookup("java:comp/env");
//		String host =  context.getInitParameter("server");
//		String port = context.getInitParameter("port");
//		String username = context.getInitParameter("user");
//		String password = context.getInitParameter("password");
//		String dbname = context.getInitParameter("dbname");

//		try {
//			Context env = (Context)new InitialContext().lookup("java:comp/env");
//			String host = (String)env.lookup("server");
//			String port = (String)env.lookup("port");
//			String username = (String)env.lookup("user");
//			String password = (String)env.lookup("password");
//			String dbname = (String)env.lookup("dbname");
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	}

	
		
		
		Con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+dbname,username,password);
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