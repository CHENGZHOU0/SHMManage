package com.shm.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shm.bean.Document;
import com.shm.dao.DocumentDao;

/**
 * Servlet implementation class DownloadFileServlet
 */
@WebServlet("/DownloadFileServlet")
public class DownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		int fid = Integer.parseInt(request.getParameter("fid"));
		
		//System.out.println("���óɹ�");
		
		Document document = new DocumentDao().achieve(fid);
		String path = document.getPath() + "//" + document.getName(); 
		
		File file = new File(path);
		
		if (!file.exists()) {
			request.setAttribute("message", "��Ҫ���ص���Դ�Ѿ���ɾ����"	);
			request.getRequestDispatcher("list_file").forward(request,response);
		}
		
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(document.getName(), "UTF-8"));
		FileInputStream in = new FileInputStream(path);
		
		OutputStream out = response.getOutputStream();
		
		byte buffer[] = new byte[1024];
		int len = 0;
        //ѭ�����������е����ݶ�ȡ������������
        while((len=in.read(buffer))>0){
            //��������������ݵ��������ʵ���ļ�����
            out.write(buffer, 0, len);
        }
        //�ر��ļ�������
        in.close();
        //�ر������
        out.close();
		
        //request.setAttribute("pid", pid	);
		//request.getRequestDispatcher("list_file").forward(request,response);
		
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
