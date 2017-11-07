package com.projecttasktree;

public class TaskBean {
	private int taskid;
	private String taskname;
	private int prerequisiteid;

	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public int getPrerequisiteid() {
		return prerequisiteid;
	}

	public void setPrerequisiteid(int prerequisiteid) {
		this.prerequisiteid = prerequisiteid;
	}

}