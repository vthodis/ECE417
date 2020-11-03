package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="Register",urlPatterns = { "/Register"})

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Register() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException{
			
			String barcode=request.getParameter("barcode");
			String name=request.getParameter("name");
			String color=request.getParameter("color");
			String description=request.getParameter("description");		
					//doGet(request,response);
			Member member=new Member(barcode,name,color,description);
			RegisterDao rDao=new RegisterDao();
			String result=rDao.insert(member);
			if(result == "Data stored successfully") {

				response.sendRedirect("view.jsp");
			}
			else {response.getWriter().print(result);}
			

			
		}
	

}
