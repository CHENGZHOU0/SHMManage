package com.shm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shm.bean.MonitoringData;
import com.shm.bean.Project;
import com.shm.bean.Sensor;
import com.shm.dao.MonitoringDataDao;
import com.shm.dao.ProjectDao;
import com.shm.dao.SensorDao;
import com.shm.utils.GetViewToken;

/**
 * Servlet implementation class WarningServlet
 */
@WebServlet("/WarningServlet")
public class WarningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WarningServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		Project project = new ProjectDao().get(pid);
		String fileId = project.getFileId();
		String projectName = project.getName();
		
		
		new GetViewToken();
		String ViewToken = GetViewToken.get(fileId);
		
		List<Sensor> sensors = new SensorDao().get(pid);
		
		int sid = sensors.get(0).getId();
		MonitoringData newest = new MonitoringDataDao().getNew(sid);
		
		request.setAttribute("pid", pid);
		request.setAttribute("pname", projectName);
		request.setAttribute("newest", newest);
		request.setAttribute("sensors", sensors);
		request.setAttribute("viewToken", ViewToken);
		
		request.getRequestDispatcher("warningDataQuery.jsp").forward(request,response);
		
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
