package DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.serial.SerialBlob;

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
}
