package com.projecttasktree;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
				request.setAttribute("project", project);
				dispatcher = context.getNamedDispatcher("project");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}