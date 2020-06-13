package com.shm.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shm.bean.Project;
import com.shm.bean.Sensor;
import com.shm.dao.SensorDao;

/**
 * Servlet implementation class UpdateSensorServlet
 */
@WebServlet("/UpdateSensorServlet")
public class UpdateSensorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSensorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		String name = request.getParameter("name");
		String datePicker = request.getParameter("date-picker");
		String samplingFrequency = request.getParameter("samplingFrequency");
		String operationCondition = request.getParameter("operationCondition");
		String maintenanceRecord = request.getParameter("maintenanceRecord");
		int elementId = Integer.parseInt(request.getParameter("elementId"));
		int stid = Integer.parseInt(request.getParameter("stid"));
		
		
		String startYear = datePicker.substring(6,10);
		String startMonth = datePicker.substring(3,5);
		String startDay = datePicker.substring(0,2);
		
		String startTime = String.format("%s-%s-%s",startYear,startMonth,startDay);
		
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse(startTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		Sensor sensor = new Sensor();
		sensor.setId(sid);
		sensor.setName(name);
		sensor.setInstallingTime(date);
		sensor.setSamplingFrequency(samplingFrequency);
		sensor.setOperationCondition(operationCondition);
		sensor.setMaintenanceRecord(maintenanceRecord);
		sensor.setElementId(elementId);
		sensor.setStid(stid);
		sensor.setPid(pid);
		
		new SensorDao().update(sensor);
		
		request.setAttribute("pid", pid);
		System.out.println(pid);
		request.getRequestDispatcher("list_sensor").forward(request,response);
		
		


		
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
