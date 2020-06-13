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
import javax.servlet.http.HttpSession;

import com.shm.bean.Project;
import com.shm.dao.ProjectDao;

/**
 * Servlet implementation class UpdateProjectServlet
 */
@WebServlet("/UpdateProjectServlet")
public class UpdateProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProjectServlet() {
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
			
			int pid = Integer.parseInt(request.getParameter("pid"));
			
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String datePicker = request.getParameter("date-picker");
			String fileId = request.getParameter("fileid");
			
			
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
					
			Project project = new Project();
			project.setId(pid);
			project.setName(name);
			project.setAddress(address);
			project.setStartTime(startTime);
			project.setFileId(fileId);
			
			new ProjectDao().update(project);
			
			response.sendRedirect("list_project");
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
