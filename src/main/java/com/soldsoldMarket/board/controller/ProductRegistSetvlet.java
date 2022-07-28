package com.soldsoldMarket.board.controller;


import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.soldsoldMarket.board.model.service.ProductRegistService;
import com.soldsoldMarket.common.util.FileRename;
import com.soldsoldMarket.member.model.vo.Member;
import com.soldsoldMarket.product.model.service.ProductService;
import com.soldsoldMarket.product.model.vo.PAdd;
import com.soldsoldMarket.product.model.vo.Product;

@MultipartConfig(
	fileSizeThreshold=1024*1024,
	maxFileSize=1024*1024*10,
	maxRequestSize = 1024*1024*10*5
)
@WebServlet("/board/regist")
public class ProductRegistSetvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProductRegistSetvlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
    	Member loginMember = (session == null) ? null : (Member) session.getAttribute("loginMember");
    	
    	if (loginMember != null) {    		
    		request.getRequestDispatcher("/views/board/regist.jsp").forward(request, response);    		
    	} else {
    		request.setAttribute("msg", "�α��� �� ����� �� �ֽ��ϴ�.");
    		request.setAttribute("location", "/");
    		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
    	}
	}

    
    @Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int result = 0;
    	Product product = null;
		
    	// ������ �ִ� ������ ���� (10MB)
    	int maxSize = 10485760;
    	
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
    	
    	// ������ ����� ���
    	String path = getServletContext().getRealPath("/resources/upload/board");
    	
    	// ���ڵ� ����
    	String encoding = "UTF-8";
    	
    	// DefaultFileRenamePolicy : �ߺ��Ǵ� �̸� �ڿ� 1 ~ 9999 ���δ�.
    	//MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding);
    	
    	//Re
    	MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding, new DefaultFileRenamePolicy());
    	
    	// ���� ����
       	Enumeration<?> files = mr.getFileNames();
    	int i = 1;
		PAdd pvo = new PAdd();
		while (files.hasMoreElements()) { // ���ε� �� ���� �̸� ������	
			String file = (String) files.nextElement(); 
			String fileName = mr.getFilesystemName(file);
			if (fileName == null) {
				fileName = "";
			}
			if (i == 1) {
				pvo.setPAimg1(fileName);
			} else if (i == 2) {
				pvo.setPAimg2(fileName);
			} else if (i == 3) {
				pvo.setPAimg3(fileName);
			} else if (i == 4) {
				pvo.setPAimg4(fileName);
			} else if (i == 5) {
				pvo.setPAimg5(fileName);
			}
			i++;
		}
	
		// �� ����	
    	// �Ķ���ͷ� �Ѿ�� ����
    	int p_id = Integer.parseInt(mr.getParameter("PNo"));
    	String p_date = mr.getParameter("PDate");
    	String m_id = mr.getParameter("writer");
    	
    	// ��
    	String category = mr.getParameter("category");
    	String p_name = mr.getParameter("title");
    	int price = Integer.parseInt(mr.getParameter("price"));
    	String p_qlt = mr.getParameter("condition");
    	String location = mr.getParameter("location");
    	String exchange = mr.getParameter("exchange");
    	int count = Integer.parseInt(mr.getParameter("count"));
    	String content = mr.getParameter("content");
    	
    	HttpSession session = request.getSession(false);
    	Member loginMember = (session == null) ? null : (Member) session.getAttribute("loginMember");
    	
    	
    	
    	if (loginMember != null) {    		
    		product = new Product();
    		
	    	product.setPNo(p_id);
	    	product.setMId(m_id);
	    	product.setCId(category);
	    	product.setPName(p_name);
	    	product.setPPrice(price);
	    	product.setPQlt(p_qlt);
	    	product.setPLocation(location);
	    	product.setPExchange(exchange);
	    	product.setPQtt(count);
	    	product.setPContents(content);
	    	
	    	 
	    	result = new ProductService().save(product);
	   
	    	if(result > 0) {
	    		request.setAttribute("msg", "�Խñ� ��� ����");
	    		request.setAttribute("location", "/board/list");
			} else {
	    		request.setAttribute("msg", "�Խñ� ��� ����");
	    		request.setAttribute("location", "/board/list");
			}
		} else {
			request.setAttribute("msg", "�α��� �� ����� �� �ֽ��ϴ�.");
			request.setAttribute("location", "/");
		}
		
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	    	}
    		
}


    
