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
@WebServlet("/updatetask")
public class UpdateTask extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int taskid=Integer.parseInt(req.getParameter("taskid"));
		String title=req.getParameter("title");
		String description=req.getParameter("description");
		String priority=req.getParameter("priority");
		String duedate=req.getParameter("duedate");
		String status=req.getParameter("status");
		int userId=Integer.parseInt(req.getParameter("userid"));
		
		Task task=new Task(taskid, title, description, priority, duedate, status, userId);
		
		UserDao dao=new UserDao();
		
		try {
			int res=dao.updateTask(task);
			if(res>0)
			{
			HttpSession ses=req.getSession();
			User u=(User)ses.getAttribute("user");
			req.setAttribute("tasks",dao.getTask(u.getUserid()));
			
			req.getRequestDispatcher("home.jsp").include(req, resp);
			
			}
			else
			{
				resp.getWriter().println("Update failed");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
