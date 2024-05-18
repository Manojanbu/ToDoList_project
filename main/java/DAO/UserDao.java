package DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import DTO.Task;

//import com.mysql.cj.xdevapi.Statement;

import DTO.User;

public class UserDao
{
// Blob imageBlob= new serialBlob(user.getuserImage());
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails?user=root&password=root");
		return con;
	}
	public static int insert(User e) throws ClassNotFoundException, SQLException
	{
		Connection con =getConnection();
		PreparedStatement pst=con.prepareStatement("insert into user values(?,?,?,?,?,?)");
		pst.setInt(1, e.getUserid());
		pst.setString(2, e.getUsername());
		pst.setString(3, e.getUseremail());
		pst.setLong(4, e.getUsercontact());
		pst.setString(5,e.getUserpassword());
		
		Blob imageBlob=new SerialBlob(e.getUserimage());
		pst.setBlob(6, imageBlob);
		
		int res=pst.executeUpdate();
		return res;
		
	}
	
	public User findByEmail(String email) throws ClassNotFoundException, SQLException 
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select * from user where useremaill=?");
		pst.setString(1,email);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			User u=new User();
			u.setUserid(rs.getInt(1));
			u.setUsername(rs.getString(2));
			u.setUseremail(rs.getString(3));
			u.setUsercontact(rs.getLong(4));
			u.setUserpassword(rs.getString(5));
			Blob image=rs.getBlob(6);
			
			byte[] imagebyte=image.getBytes(1, (int)image.length());
			u.setUserimage(imagebyte);
			
			return u;
		}
		else
		{
			return null;
		}
		
	}  
	
//	addTask 
	public int createTask(Task t) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst =con.prepareStatement("insert into task values(?,?,?,?,?,?,?)");
		pst.setInt(1, t.getTaskid());
		pst.setString(2,t.getTasktitle());
		pst.setString(3, t.getTaskdescription());
		pst.setString(4, t.getTaskpriority());
		pst.setString(5,t.getTaskduedate());
		pst.setString(6, t.getTaskstatus());
		pst.setInt(7, t.getUserId());
		
		int res=pst.executeUpdate();
		return res;
	}
	
//display Task
	public List<Task> getTask(int userid) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select * from task where userId=?");
		pst.setInt(1, userid);
		ResultSet rs=pst.executeQuery();
		List<Task> tasks=new ArrayList<Task>();
		while(rs.next())
		{
			Task task=new Task(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
			tasks.add(task);
		}
		return tasks;
	}
	
//	delete task
	
	public int deleteTask(int taskid) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("delete from task where taskId=?");
		pst.setInt(1, taskid);
		int res=pst.executeUpdate();
		return res;
	}
	public Task findByTaskId(int taskid) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select *from task where taskId=?");
		pst.setInt(1, taskid);
		ResultSet rs=pst.executeQuery();
		rs.next();		
		Task task=new Task(taskid,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
		return task;
	}
	public int updateTask(Task task) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("update task set taskTitle=?,taskDescription=?,taskPriority=?,taskDueDate=?,taskStatus=?,userId=? where taskId=?");
		
		pst.setString(1,task.getTasktitle());
		pst.setString(2,task.getTaskdescription());
		pst.setString(3,task.getTaskpriority());
		pst.setString(4,task.getTaskduedate());
		pst.setString(5,task.getTaskstatus());
		pst.setInt(6,task.getUserId());
		pst.setInt(7,task.getTaskid());
		
		int res=pst.executeUpdate();
		return res;
	}
	public int autoUserId() throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select max(userid) from user");
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			return rs.getInt(1)+1;	
		}
		else
		{
			return 1;
		}
		
	}
	public int autoTaskId() throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select max(taskId) from task");
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			return rs.getInt(1)+1;	
		}
		else
		{
			return 1;
		}
		
	}
	public void updatePriorityBasedOnDuration() throws SQLException, ClassNotFoundException
	{
	Connection con = getConnection();
	Statement st = con.createStatement();
	st.execute("UPDATE task SET taskPriority = 'high' WHERE taskDueDate BETWEEN CURDATE() AND CURDATE() +  INTERVAL 3 DAY");
	st.execute("UPDATE task SET taskPriority = 'medium' WHERE taskDueDate BETWEEN CURDATE() + INTERVAL 4 DAY AND CURDATE() + INTERVAL 7 DAY");
	st.execute("UPDATE task SET taskPriority = 'low' WHERE taskDueDate > CURDATE() + INTERVAL 7 DAY");
    }
}