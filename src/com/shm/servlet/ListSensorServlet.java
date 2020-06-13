package com.shm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shm.bean.Project;
import com.shm.bean.Sensor;
import com.shm.dao.ProjectDao;
import com.shm.dao.SensorDao;

/**
 * Servlet implementation class ListSensorServlet
 */
@WebServlet("/ListSensorServlet")
public class ListSensorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSensorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		Project project = new ProjectDao().get(pid);
		String projectName = project.getName();
		
		//根据pid查询项目信息
		List<Sensor> sensors = new SensorDao().get(pid);
		
		request.setAttribute("username", username);
		request.setAttribute("pname", projectName);
		request.setAttribute("sensors", sensors);
		request.setAttribute("pid", pid);
		request.getRequestDispatcher("listSensor.jsp").forward(request,response);
		
		// TODO Auto-generated method stub
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
