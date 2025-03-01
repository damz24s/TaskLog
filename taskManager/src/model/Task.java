package model;
import java.io.Serializable;


public class Task implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	int id;
	String taskName;
	String priorityLvl;
	String status;
	

	public Task(int id, String taskName, String priorityLvl, String status) {
		this.id = id;
		this.taskName = taskName;
		this.priorityLvl = priorityLvl;
		this.status = status;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getPriorityLvl() {
		return priorityLvl;
	}

	public void setPriorityLvl(String priorityLvl) {
		this.priorityLvl = priorityLvl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
