package com.shm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shm.bean.Project;
import com.shm.dao.ProjectDao;

/**
 * Servlet implementation class EditProjectServlet
 */
@WebServlet("/EditProjectServlet")
public class EditProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProjectServlet() {
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
			int pid = Integer.parseInt(request.getParameter("pid"));

			Project project = new ProjectDao().get(pid);
			request.setAttribute("project", project);
			request.setAttribute("pid", pid	);
			//×ªµ½±à¼­Ò³Ãæ
			request.getRequestDispatcher("editproject.jsp").forward(request,response);
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
