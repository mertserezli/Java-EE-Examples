package com.projecttasktree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProjectDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static ProjectBean getProject(ProjectBean bean) {
		PreparedStatement ps = null;
		int id = bean.getProjectid();
		String searchQuery = "select * from PROJECT where id=?";
		try {
			ConnectionManager connect = new ConnectionManager();
			currentCon = connect.getConnection();
			ps = currentCon.prepareStatement(searchQuery);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			boolean more = rs.next();
			if (!more) {
				bean.setValid(false);
			} else if (more) {
				String projectname = rs.getString("name");

				bean.setProjectname(projectname);

				bean.setValid(true);
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
		return bean;
	}
}
