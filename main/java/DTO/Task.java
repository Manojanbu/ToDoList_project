package DTO;

public class Task 
{	
	private int taskid;
	private String tasktitle;
	private String taskdescription;
	private String taskpriority;
	private String taskduedate;
	private String taskstatus;
	private int userId;
	public Task(int taskid, String tasktitle, String taskdescription, String taskpriority, String taskduedate,
			String taskstatus, int userId) {
		super();
		this.taskid = taskid;
		this.tasktitle = tasktitle;
		this.taskdescription = taskdescription;
		this.taskpriority = taskpriority;
		this.taskduedate = taskduedate;
		this.taskstatus = taskstatus;
		this.userId = userId;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public String getTasktitle() {
		return tasktitle;
	}
	public void setTasktitle(String tasktitle) {
		this.tasktitle = tasktitle;
	}
	public String getTaskdescription() {
		return taskdescription;
	}
	public void setTaskdescription(String taskdescription) {
		this.taskdescription = taskdescription;
	}
	public String getTaskpriority() {
		return taskpriority;
	}
	public void setTaskpriority(String taskpriority) {
		this.taskpriority = taskpriority;
	}
	public String getTaskduedate() {
		return taskduedate;
	}
	public void setTaskduedate(String taskduedate) {
		this.taskduedate = taskduedate;
	}
	public String getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
	
}
