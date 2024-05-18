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
@WebServlet("/displaytask")
public class AddTask extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		UserDao dao=new UserDao();
		
//		int id=Integer.parseInt(req.getParameter("taskid"));
		int id;
		try {
			id = dao.autoTaskId();
		
		String title=req.getParameter("tasktitle");
		String description=req.getParameter("taskdescription");
		String priority=req.getParameter("taskpriority");
		String duedate=req.getParameter("taskduedate");
		
		User user=(User)req.getSession().getAttribute("user");

		int userid=user.getUserid();
		Task task=new Task(id, title, description, priority, duedate, "pending", userid);
		
		
		try {
			int res=dao.createTask(task);
			if(res>0)
			{
				HttpSession ses=req.getSession();
				User u=(User)ses.getAttribute("user");
				req.setAttribute("tasks", dao.getTask(u.getUserid()));
				RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
				rd.include(req, resp);
			}
			else
			{
				resp.getWriter().println("task added failed");
			
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
