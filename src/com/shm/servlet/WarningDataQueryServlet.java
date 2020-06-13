package com.shm.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.shm.bean.SimulationData;
import com.shm.dao.MonitoringDataDao;
import com.shm.dao.SimulationDataDao;

/**
 * Servlet implementation class WarningDataQueryServlet
 */
@WebServlet("/WarningDataQueryServlet")
public class WarningDataQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WarningDataQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		//接受表单传递的参数,类型为String,并转换成yyyy-mm-dd的格式
		String dateRange = request.getParameter("date-range-picker");
		
		String startYear = dateRange.substring(6,10);
		String startMonth = dateRange.substring(0,2);
		String startDay = dateRange.substring(3,5);
		
		String endYear = dateRange.substring(19,23);
		String endMonth = dateRange.substring(13,15);
		String endDay = dateRange.substring(16,18);
		
		String startTime = String.format("%s-%s-%s",startYear,startMonth,startDay);
		String endTime = String.format("%s-%s-%s",endYear,endMonth,endDay);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//定义count为时间段内的天数
		long count = 0;
		
		try {
			count = (long) ((sdf.parse(endTime).getTime() - sdf.parse(startTime).getTime()) / (1000*60*60*24)) + 1;
			//System.out.println(count);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//将startTime转为java.util.date
		Date startTimeDate = null;
		
		try {
			startTimeDate = sdf.parse(startTime);
			//System.out.println(startTimeDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		List<SimulationData> simulationDatas = new ArrayList<SimulationData>();
		
		for (int i = 0; i < count; i++) {

			Calendar calendar = new GregorianCalendar();
			
			calendar.setTime(startTimeDate);
			
			calendar.add(calendar.DATE,i);
			Date likeDateTime = calendar.getTime();
			
			String likeTime = sdf.format(likeDateTime) + "%";
			System.out.println(likeTime);
			
			simulationDatas = new SimulationDataDao().getWarning(startTime, endTime, sid);
			
		}
		
		
		
		
		////////////////////////////
		
		
		
//		List<MonitoringData> monitoringDatas = new ArrayList<MonitoringData>();
//		
//		for (int i = 0; i < count; i++) {
//
//			Calendar calendar = new GregorianCalendar();
//			
//			calendar.setTime(startTimeDate);
//			
//			calendar.add(calendar.DATE,i);
//			Date likeDateTime = calendar.getTime();
//			
//			String likeTime = sdf.format(likeDateTime) + "%";
//			
//			MonitoringData monitoringData = null;
//			
//			if (value.equals("max")) {
//				monitoringData = new MonitoringDataDao().getMax(likeTime,sid);
//				
//			} else if (value.equals("min")) {
//				monitoringData = new MonitoringDataDao().getMin(likeTime,sid);
//				
//			} else {
//				monitoringData = new MonitoringDataDao().getAverage(likeTime,sid);
//			}
//			
//			
//			if (monitoringData != null) {
//				monitoringDatas.add(monitoringData);
//			}
//			
//		}
//
//		
//		if (monitoringDatas.size()>0) {
//			//****************将数据以字符串的形式传递****************************
//			
//			String times = "";
//			String xs = "";
//			String ys = "";
//			String ts = "";
//				
//			
//				
//			for (int i = 0; i < monitoringDatas.size(); i++) {
//				if (monitoringDatas.get(i).getTime() != null) {
//					
//					
//					times += "'" + monitoringDatas.get(i).getTime().substring(0,10) + "',";
//					xs += monitoringDatas.get(i).getX() + ",";
//					ys += monitoringDatas.get(i).getY() + ",";
//					ts += monitoringDatas.get(i).getT() + ",";
//				}
//			}
//				
//			
//			
//			if (times.length() != 0) {
//				times = times.substring(0, times.length()-1);
//				xs = xs.substring(0, xs.length()-1);
//				ys = ys.substring(0, ys.length()-1);
//				ts = ts.substring(0, ts.length()-1);
//			}
//			
//			request.setAttribute("monitoringDatas", monitoringDatas);
//			request.setAttribute("times", times);
//			request.setAttribute("xs", xs);
//			request.setAttribute("ys", ys);
//			request.setAttribute("ts", ts);
//			
//		}	
		
		request.setAttribute("monitoringDatas", simulationDatas);
		request.setAttribute("pid", pid);
		
		request.getRequestDispatcher("listWarningData.jsp").forward(request, response);
		
		
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
