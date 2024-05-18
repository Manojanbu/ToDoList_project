package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDao;
import DTO.Task;
import DTO.User;
@WebServlet("/delete")
public class DeleteTask extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int taskid=Integer.parseInt(req.getParameter("taskid"));

		UserDao dao=new UserDao();
		
		try {
			
			
			HttpSession ses=req.getSession();
			User u=(User)ses.getAttribute("user");
			if(u!=null)
			{
				Task task=dao.findByTaskId(taskid);
					if(u.getUserid()==task.getUserId())
					{
						int res=dao.deleteTask(taskid);
						req.setAttribute("tasks", dao.getTask(u.getUserid()));
						RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
						rd.include(req, resp);
					}
					else
					{
						req.getRequestDispatcher("logout").include(req, resp);
					}
			}
			else
			{
				req.getRequestDispatcher("login.jsp").include(req, resp);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
