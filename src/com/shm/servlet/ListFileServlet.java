package com.shm.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shm.bean.Document;
import com.shm.bean.Project;
import com.shm.bean.Sensor;
import com.shm.dao.DocumentDao;
import com.shm.dao.ProjectDao;
import com.shm.dao.SensorDao;

/**
 * Servlet implementation class ListFileServlet
 */
@WebServlet("/ListFileServlet")
public class ListFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		Project project = new ProjectDao().get(pid);
		String projectName = project.getName();
		
		//根据pid查询项目信息
		List<Document> files = new DocumentDao().get(pid);
		
		request.setAttribute("name", username);
		request.setAttribute("pname", projectName);
		request.setAttribute("files", files);
		request.setAttribute("pid", pid);
		
		request.getRequestDispatcher("listFile.jsp").forward(request,response);
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
