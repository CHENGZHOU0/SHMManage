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
		 * ��Ŀ�б�servlet�������û�ID��ѯ���������Ŀ���б�չʾ
		 */
		
		//��session����userId��username
		HttpSession session = request.getSession();
		
		//System.out.println(session.getAttribute("userId"));
		
		//����¼��ʱsession������ʱ�����·��ص�¼ҳ��
		if (session.getAttribute("userId") == null) {
			response.sendRedirect("login.jsp");
		}else {
			
			int userId = (int) session.getAttribute("userId");
			String username = (String) session.getAttribute("username");
			
			//����usesId��ѯ��Ŀ��Ϣ
			//�½�projects�б�
			List<Project> projects = new ArrayList<Project>();
			//ͨ��userId�õ�UserProject
			List<UserProject> userProjects = new UserProjectDao().get(userId);
			
			//ͨ��userProjcets�õ����û����е�project���ŵ�projects�б���
			for (int i = 0; i < userProjects.size(); i++) {
				Project project = new ProjectDao().get(userProjects.get(i).getPid());
				projects.add(project);
			}
			
			//����projects����ת������Ŀ�б�ҳ��
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
