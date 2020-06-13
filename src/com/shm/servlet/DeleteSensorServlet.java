package com.shm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shm.dao.DocumentDao;
import com.shm.dao.SensorDao;

/**
 * Servlet implementation class DeleteSensorServlet
 */
@WebServlet("/DeleteSensorServlet")
public class DeleteSensorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSensorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("chenggong");
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		new SensorDao().delete(sid);
		
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
