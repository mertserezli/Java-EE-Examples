package com.projecttasktree;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TasksServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		ProjectBean project;
		RequestDispatcher dispatcher;
		ServletContext context = getServletContext();
		String Sprojectid = request.getPathInfo();
		try {
			Sprojectid = Sprojectid.substring(1);
			int Iid = Integer.parseInt(Sprojectid);
			project = new ProjectBean();
			project.setProjectid(Iid);
			project = ProjectDAO.getProject(project);
			if (project.isValid()) {
				String tree = getTreeHTML(project);
				request.setAttribute("tree", tree);
				dispatcher = context.getNamedDispatcher("taskTree");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getTreeHTML(ProjectBean project) {
		String html = "";
		ArrayList<TaskBean> roots = TasksDAO.getRootTasks(project);
		// for every prerequisite=null task(not prerequisite of anything) do
		for (TaskBean task : roots) {
			html += "<div class=\"tree\"> <ul>";
			// get tasks and employees that is child of that task(recursive)
			html = appendChilds(task, html);
			// return string
			html += "</ul> </div>";
		}
		return html;
	}

	private String appendChilds(TaskBean parentTask, String html) {
		ArrayList<EmployeeBean> employees = TasksDAO.getEmployeesWorksOn(parentTask);
		ArrayList<TaskBean> childTasks = TasksDAO.getChildTasks(parentTask);

		html += "<li>";
		html += "<a href=\"task/" + parentTask.getTaskid() + "\" class=\"task\">" + parentTask.getTaskname() + "</a>";

		if (!employees.isEmpty() || !childTasks.isEmpty())
			html += "<ul>";

		if (!employees.isEmpty()) {
			for (EmployeeBean employee : employees) {
				html += "<li>" + "<a href=\"" + employee.getEmployeeid() + "\" class=\"employee\">" + employee.getName()
						+ "</a> </li>";
			}
		}

		if (!childTasks.isEmpty()) {
			for (TaskBean task : childTasks) {
				html = appendChilds(task, html);
			}
		}
		html += "</li>";

		if (!employees.isEmpty() || !childTasks.isEmpty())
			html += "</ul>";
		return html;
	}

}
