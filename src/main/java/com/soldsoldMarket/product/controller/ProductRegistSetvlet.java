package com.soldsoldMarket.product.controller;


import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.soldsoldMarket.product.model.service.ProductService;
import com.soldsoldMarket.common.util.FileRename;
import com.soldsoldMarket.member.model.vo.Member;
import com.soldsoldMarket.product.model.vo.PAdd;
import com.soldsoldMarket.product.model.vo.Product;

@WebServlet("/board/regist")
public class ProductRegistSetvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProductRegistSetvlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    

    }
    @Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int result = 0;
    	int result2 = 0;
    	Product product = null;
		
    	// ������ �ִ� ������ ���� (10MB)
    	int maxSize = 10485760;
    	
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
    	
    	// ������ ����� ���
    	String path = getServletContext().getRealPath("/resources/upload/product");
    	
    	// ���ڵ� ����
    	String encoding = "UTF-8";
    	
    	// DefaultFileRenamePolicy : �ߺ��Ǵ� �̸� �ڿ� 1 ~ 9999 ���δ�.
    	MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding, new FileRename());
    	
	
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
    	
    	// ���� ����
       	Enumeration<?> files = mr.getFileNames();
    	int i = 1; //����
    	PAdd padd = new PAdd();
		
    	//files��� ���ϵ��� ���������� ���������� ����.
		while (files.hasMoreElements()) { // ���ε� �� ���� �̸� ������
			//files�� ���� �׸��� filed�� ��´�.
			String file = (String) files.nextElement();
			//mr���� �ش� file�� �̸��� filename�� ��´�.
			String fileName = mr.getFilesystemName(file);
			if (fileName == null) {
				fileName = "";
			}
			if (i == 1) {
				//i�� 1�̸� pvo�� setPAimg1�� �ش� ���ϸ��� ��´�.
				padd.setPAimg5(fileName);
			} else if (i == 2) {
				padd.setPAimg4(fileName);
			} else if (i == 3) {
				padd.setPAimg3(fileName);
			} else if (i == 4) {
				padd.setPAimg2(fileName);
			} else if (i == 5) {
				padd.setPAimg1(fileName);
			}
			i++;//����
		}
    	
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
	    	
	    	 
	    	result = new ProductService().insertProduct(product);
	    	result2 = new ProductService().insertPAdd(padd, product);
	    	
	    	if(result > 0 && result2 > 0) {
        		request.setAttribute("msg", "�Խñ� ��� ����");
        		request.setAttribute("location", "/");
    		} else {
        		request.setAttribute("msg", "�Խñ� ��� ����");
        		request.setAttribute("location", "/");
    		}

    }
}
