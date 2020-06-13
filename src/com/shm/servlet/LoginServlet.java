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

import com.shm.bean.Project;
import com.shm.bean.User;
import com.shm.bean.UserProject;
import com.shm.dao.ProjectDao;
import com.shm.dao.UserDao;
import com.shm.dao.UserProjectDao;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/**
		 * 登录servlet，验证用户名密码，正确转入项目列表
		 */
		//将表单传来的数据编码，防止中文乱码
		request.setCharacterEncoding("UTF-8"); 
		//获取用户名
		String username = request.getParameter("username");
		//获取密码
		String password = request.getParameter("password");
		//通过用户名和密码到数据库查询相应用户数据是否存在
		User user = new UserDao().get(username, password);
		//登录校验校验
		if (user==null) {
			//登录失败 返回登录页面  转发（转发能传递setAttribute中的数据）
			request.setAttribute("msg","用户名密码错误");
			request.getRequestDispatcher("login.jsp").forward(request,response);
			//重定向 到页面中无法获取到setAttribute中的数据
			//response.sendRedirect("login.jsp");
		}else {
			
			//创建session，保存用户ID、用户名及用户类型
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("username",user.getName());
			session.setAttribute("userType", user.getType());
			
			//转发到项目列表servlet
			//request.getRequestDispatcher("list_project").forward(request,response);
			response.sendRedirect("list_project");
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
