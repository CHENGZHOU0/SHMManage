package com.shm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shm.bean.SensorType;
import com.shm.dao.ProjectDao;
import com.shm.dao.SensorTypeDao;

/**
 * Servlet implementation class UpdateSensorTypeServlet
 */
@WebServlet("/UpdateSensorTypeServlet")
public class UpdateSensorTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSensorTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("userId") == null) {
			response.sendRedirect("login.jsp");
		}else {
			request.setCharacterEncoding("UTF-8");
			
			int stid = Integer.parseInt(request.getParameter("stid"));
			
			String name = request.getParameter("name");
			
			String parameter1 = request.getParameter("parameter1");
			float upperlimit1 = Float.parseFloat(request.getParameter("upperlimit1"));
			float lowerlimit1 = Float.parseFloat(request.getParameter("lowerlimit1"));
		
			String parameter2 = request.getParameter("parameter2");
			float upperlimit2 = Float.parseFloat(request.getParameter("upperlimit2"));
			float lowerlimit2 = Float.parseFloat(request.getParameter("lowerlimit2"));
			
			String parameter3 = request.getParameter("parameter3");
			float upperlimit3 = Float.parseFloat(request.getParameter("upperlimit3"));
			float lowerlimit3 = Float.parseFloat(request.getParameter("lowerlimit3"));
			
			
			
			
			SensorType sensorType = new SensorType();
			sensorType.setId(stid);
			sensorType.setName(name);
			sensorType.setParameter1(parameter1);
			sensorType.setUpperlimit1(upperlimit1);
			sensorType.setLowerlimit1(lowerlimit1);
			
			sensorType.setParameter2(parameter2);
			sensorType.setUpperlimit2(upperlimit2);
			sensorType.setLowerlimit2(lowerlimit2);
			
			sensorType.setParameter3(parameter3);
			sensorType.setUpperlimit3(upperlimit3);
			sensorType.setLowerlimit3(lowerlimit3);
			
			new SensorTypeDao().update(sensorType);
			
			response.sendRedirect("list_sensortype");
		}
		
		
		
		
		
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
