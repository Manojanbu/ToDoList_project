package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.UserDao;
import DTO.User;
@WebServlet("/SaveUser")
@MultipartConfig(maxFileSize = 10*1024*1024)
public class SaveUser extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long contact=Long.parseLong(req.getParameter("contact"));
		String pass=req.getParameter("pass");
		//to get image file from the front end 
		Part imagePart=req.getPart("image");
		//converting image file(part) into byte[]
		byte[] imageByte=imagePart.getInputStream().readAllBytes();
		
		User user=new User(id, name, email, contact, pass, imageByte);
		
		UserDao dao=new UserDao();
		
		try {
			int res=dao.insert(user);
			
			if(res>0)
			{
				resp.getWriter().println("signup succes");
				resp.sendRedirect("login.jsp");
			}
			else
			{
				resp.getWriter().println("signup failed");
				resp.sendRedirect("Signup.jsp");
			}
			
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
