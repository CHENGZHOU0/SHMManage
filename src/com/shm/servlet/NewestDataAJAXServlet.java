package com.shm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.shm.bean.MonitoringData;
import com.shm.bean.Sensor;
import com.shm.dao.MonitoringDataDao;
import com.shm.dao.SensorDao;

/**
 * Servlet implementation class NewestDataAJAXServlet
 */
@WebServlet("/NewestDataAJAXServlet")
public class NewestDataAJAXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewestDataAJAXServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("收到请求");
		
		int sid = Integer.parseInt(request.getParameter("sid"));
		//System.out.println(sid);
		
		MonitoringData newest = new MonitoringDataDao().getNew(sid);
		System.out.println(newest.toString());
		
		//将JAVA对象转换为JSON格式的字符串
		Gson gson = new Gson();
		
		String json = gson.toJson(newest);
		
		System.out.println(json);
		
		response.getWriter().write(json);
		
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
