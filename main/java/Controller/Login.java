package Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDao;
import DTO.Task;
import DTO.User;
@WebServlet("/login")
public class Login extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		
//		User e=new User();
		
		UserDao dao=new UserDao();
		try 
		{
			User u=dao.findByEmail(email);
			
			if(u!=null)
			{
				if(u.getUserpassword().equals(password))
				{
					List<Task> tasks=dao.getTask(u.getUserid());
					req.setAttribute("tasks", tasks);
					
					HttpSession ses=req.getSession();
					ses.setAttribute("user", u);
//					req.getSession().setAttribute("User", u);
					req.getRequestDispatcher("home.jsp").include(req, resp);
				}
				else
				{
					req.setAttribute("message", "Loginfailes");
					req.getRequestDispatcher("login.jsp").include(req, resp);
				}
			}
			else
			{
				req.setAttribute("message", "Login failed");
				req.getRequestDispatcher("login.jsp").include(req, resp);
			}
		}
		catch (ClassNotFoundException | SQLException ex) 
		{
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
}
