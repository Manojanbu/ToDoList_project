
package Controller;

import java.sql.SQLException;

import DAO.UserDao;

public class Schedular implements Runnable
{
	@Override
	public void run()
	{
		while(!Thread.currentThread().isInterrupted()) 
		{
			UserDao dao = new UserDao();

			try 
			{
				dao.updatePriorityBasedOnDuration();
				Thread.sleep(1000*30);

			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			} 
			catch (InterruptedException e)
			{
				Thread.currentThread().interrupt();
			}		  
		}		
	}
}



