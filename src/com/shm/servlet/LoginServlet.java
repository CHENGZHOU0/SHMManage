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
		 * ��¼servlet����֤�û������룬��ȷת����Ŀ�б�
		 */
		//�������������ݱ��룬��ֹ��������
		request.setCharacterEncoding("UTF-8"); 
		//��ȡ�û���
		String username = request.getParameter("username");
		//��ȡ����
		String password = request.getParameter("password");
		//ͨ���û��������뵽���ݿ��ѯ��Ӧ�û������Ƿ����
		User user = new UserDao().get(username, password);
		//��¼У��У��
		if (user==null) {
			//��¼ʧ�� ���ص�¼ҳ��  ת����ת���ܴ���setAttribute�е����ݣ�
			request.setAttribute("msg","�û����������");
			request.getRequestDispatcher("login.jsp").forward(request,response);
			//�ض��� ��ҳ�����޷���ȡ��setAttribute�е�����
			//response.sendRedirect("login.jsp");
		}else {
			
			//����session�������û�ID���û������û�����
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("username",user.getName());
			session.setAttribute("userType", user.getType());
			
			//ת������Ŀ�б�servlet
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
