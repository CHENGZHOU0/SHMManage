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

import com.shm.bean.Sensor;
import com.shm.dao.ProjectDao;
import com.shm.dao.SensorDao;

/**
 * Servlet implementation class AddSensorServlet
 */
@WebServlet("/AddSensorServlet")
public class AddSensorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSensorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		String name = request.getParameter("name");
		
		String datePicker = request.getParameter("date-picker");
		String Year = datePicker.substring(6,10);
		String Month = datePicker.substring(3,5);
		String Day = datePicker.substring(0,2);
		
		String installingTime = String.format("%s-%s-%s",Year,Month,Day);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse(installingTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String samplingFrequency = request.getParameter("samplingFrequency");
		String operationCondition = request.getParameter("operationCondition");
		String maintenanceRecord = request.getParameter("maintenanceRecord");
		
		int elementId = Integer.parseInt(request.getParameter("elementId"));
		int stid = Integer.parseInt(request.getParameter("stid"));
		
		Sensor sensor = new Sensor();
		sensor.setName(name);
		sensor.setInstallingTime(date);
		sensor.setSamplingFrequency(samplingFrequency);
		sensor.setOperationCondition(operationCondition);
		sensor.setMaintenanceRecord(maintenanceRecord);
		sensor.setElementId(elementId);
		sensor.setStid(stid);
		sensor.setPid(pid);
		
		new SensorDao().add(sensor);
		
		request.setAttribute("pid", pid);
		
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
