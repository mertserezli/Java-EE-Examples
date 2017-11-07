package com.projecttasktree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TasksDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static ArrayList<TaskBean> getRootTasks(ProjectBean project) {
		PreparedStatement ps = null;
		String searchQuery = "select * from TASK where projectid=? and prerequisiteid is NULL";
		ArrayList<TaskBean> result = new ArrayList<TaskBean>();
		try {
			ConnectionManager connect = new ConnectionManager();
			currentCon = connect.getConnection();
			ps = currentCon.prepareStatement(searchQuery);
			ps.setInt(1, project.getProjectid());
			rs = ps.executeQuery();
			while (rs.next()) {
				TaskBean task = new TaskBean();
				int taskid = rs.getInt("taskid");
				String taskname = rs.getString("taskname");

				task.setTaskid(taskid);
				task.setTaskname(taskname);

				result.add(task);
			}
		} catch (Exception ex) {
			System.out.println("Failed: An Exception has occurred! " + ex);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return result;
	}

	public static ArrayList<TaskBean> getChildTasks(TaskBean parentTask) {
		PreparedStatement ps = null;
		String searchQuery = "select b.taskid, b.taskname from TASK a, TASK b where a.taskid=? and b.prerequisiteid=a.taskid";
		ArrayList<TaskBean> result = new ArrayList<TaskBean>();
		try {
			ConnectionManager connect = new ConnectionManager();
			currentCon = connect.getConnection();
			ps = currentCon.prepareStatement(searchQuery);
			ps.setInt(1, parentTask.getTaskid());
			rs = ps.executeQuery();
			while (rs.next()) {
				TaskBean task = new TaskBean();
				int taskid = rs.getInt("taskid");
				String taskname = rs.getString("taskname");

				task.setTaskid(taskid);
				task.setTaskname(taskname);

				result.add(task);
			}
		} catch (Exception ex) {
			System.out.println("Failed: An Exception has occurred! " + ex);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return result;
	}

	public static ArrayList<EmployeeBean> getEmployeesWorksOn(TaskBean task) {
		PreparedStatement ps = null;
		String searchQuery = "select * from WORKSON w, EMPLOYEE e where w.taskid=? AND w.employeeid=e.employeeid";
		ArrayList<EmployeeBean> result = new ArrayList<EmployeeBean>();
		try {
			ConnectionManager connect = new ConnectionManager();
			currentCon = connect.getConnection();
			ps = currentCon.prepareStatement(searchQuery);
			ps.setInt(1, task.getTaskid());
			rs = ps.executeQuery();
			while (rs.next()) {
				EmployeeBean employee = new EmployeeBean();
				int employeeid = rs.getInt("employeeid");
				String employeename = rs.getString("name");

				employee.setEmployeeid(employeeid);
				employee.setName(employeename);

				result.add(employee);
			}
		} catch (Exception ex) {
			System.out.println("Failed: An Exception has occurred! " + ex);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return result;
	}

}
