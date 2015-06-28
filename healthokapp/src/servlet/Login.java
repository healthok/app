package servlet;

import java.io.IOException;
import java.io.PrintWriter;





import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
	}
      

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int authenticateResult = -1;
		PrintWriter out=response.getWriter();
		out.println("HELLO");
		String uname=request.getParameter("username"); 
		String pass=request.getParameter("password");
		
		
		authenticateResult = security.Security.Authenticate (uname, pass);

		if(authenticateResult==1){
			PrintWriter output=response.getWriter();
			output.println("login successful ");
				
		}
		else  
		{
			PrintWriter output=response.getWriter(); 
			output.println("Invalid username/password");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
