package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.User;

/**
 * Servlet implementation class Testservlet
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Signup() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		PrintWriter out=response.getWriter();
		out.println("HELLO next");
		String FirstName=request.getParameter("fname");
		String LastName=request.getParameter("lname");
		String emailId=request.getParameter("email"); 
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		
		User us=new User();
		us.setFirstName(FirstName);
		us.setLastName(LastName);
		us.setEmailId(emailId);
		us.setPhone(phone);
		us.setPassword(password);
		//HttpSession session=request.getSession(true);
		out.println(FirstName+"\n");
		out.println(LastName+"\n");
		out.println(emailId+"\n");
		out.println(phone+"\n");
		
		
		//Call Biz Layer
		biz.User.Save(us);
		out.println(password+"\n");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
