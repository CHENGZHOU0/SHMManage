package com.shm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shm.bean.User;
import com.shm.bean.Project;
import com.shm.bean.UserProject;
import com.shm.dao.UserDao;
import com.shm.dao.ProjectDao;
import com.shm.dao.UserProjectDao;

/**
 * Servlet implementation class ListProjectServlet
 */
@WebServlet("/ListProjectServlet")
public class ListProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * 项目列表servlet，根据用户ID查询所管理的项目并列表展示
		 */
		
		//从session接受userId、username
		HttpSession session = request.getSession();
		
		//System.out.println(session.getAttribute("userId"));
		
		//当登录超时session被回收时，重新返回登录页面
		if (session.getAttribute("userId") == null) {
			response.sendRedirect("login.jsp");
		}else {
			
			int userId = (int) session.getAttribute("userId");
			String username = (String) session.getAttribute("username");
			
			//根据usesId查询项目信息
			//新建projects列表
			List<Project> projects = new ArrayList<Project>();
			//通过userId得到UserProject
			List<UserProject> userProjects = new UserProjectDao().get(userId);
			
			//通过userProjcets得到该用户所有的project并放到projects列表中
			for (int i = 0; i < userProjects.size(); i++) {
				Project project = new ProjectDao().get(userProjects.get(i).getPid());
				projects.add(project);
			}
			
			//带着projects数据转发到项目列表页面
			request.setAttribute("projects", projects);
			request.getRequestDispatcher("listProject.jsp").forward(request,response);
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
