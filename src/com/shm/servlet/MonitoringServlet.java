package com.shm.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shm.bean.MonitoringData;
import com.shm.bean.Project;
import com.shm.bean.Sensor;
import com.shm.bean.SimulationData;
import com.shm.dao.MonitoringDataDao;
import com.shm.dao.ProjectDao;
import com.shm.dao.SensorDao;
import com.shm.dao.SimulationDataDao;
import com.shm.utils.GetViewToken;

/**
 * Servlet implementation class MonitoringServlet
 */
@WebServlet("/MonitoringServlet")
public class MonitoringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonitoringServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//获取pid
		int pid = Integer.parseInt(request.getParameter("pid"));
		//获取project，fileId
		Project project = new ProjectDao().get(pid);
		String fileId = project.getFileId();
		String projectName = project.getName();
		//获取viewToken
		new GetViewToken();
		String ViewToken = GetViewToken.get(fileId);
		
		//获取该项目传感器列表
		List<Sensor> sensors = new SensorDao().get(pid);
		
		if (!(sensors.size()==0)) {
			//获取第一个传感器的ID
			int sid = sensors.get(0).getId();
			//通过传感器ID获取最新数据
			SimulationData newest = new SimulationDataDao().getNew(sid);
			
			request.setAttribute("newest", newest);
		}
		
		
		
		
		
		//////////
		

		
//		Calendar calendar = new GregorianCalendar(2020, 0, 1, 0, 0, 0);
//		
//		for (int i = 0; i < 3120; i++) {
//			for (int j = 0; j < sensors.size(); j++) {
//				SimulationData Data = new SimulationData();
//				DecimalFormat df = new DecimalFormat("0.0000");
//				
//				Date time = calendar.getTime();
//				
//				calendar.add(Calendar.HOUR_OF_DAY, 1);
//				
//				String value1 = df.format(2 * Math.random() -1);
//				String value2 = df.format(2 * Math.random() -1);
//				String value3 = df.format(2 * Math.random() -1);
//
//				Data.setTime(time);
//				Data.setValue1(value1);
//				Data.setValue2(value2);
//				Data.setValue3(value3);
//				Data.setSid(sensors.get(j).getId());
//				
//				new SimulationDataDao().add(Data);
//			}
//		}
		
		
		//////////
		
		request.setAttribute("pid", pid);
		request.setAttribute("pname", projectName);
		request.setAttribute("sensors", sensors);
		request.setAttribute("viewToken", ViewToken);
		
		request.getRequestDispatcher("monitoringDataQuery.jsp").forward(request,response);
		
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
