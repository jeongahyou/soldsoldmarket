package com.soldsoldMarket.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.soldsoldMarket.common.util.FileRename;
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
    	Product product = null;
    	
    	// ������ ����� ���
    	String path = getServletContext().getRealPath("/resources/upload/board");
		
    	// ������ �ִ� ������ ���� (10MB)
    	int maxSize = 10485760;
    	
    	// ���ڵ� ����
    	String encoding = "UTF-8";
    	
    	// DefaultFileRenamePolicy : �ߺ��Ǵ� �̸� �ڿ� 1 ~ 9999 ���δ�.
    	// MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding, new FileRename());
    	
    	// �� �Ķ���ͷ� �Ѿ�� ����
    	String category = request.getParameter("category");
    	String title = request.getParameter("title");
    	String price = request.getParameter("price");
    	String condition = request.getParameter("condition");
    	String place = request.getParameter("place");
    	String exchange = request.getParameter("exchange");
    	String count = request.getParameter("count");
    	String content = request.getParameter("content");
    	
    	System.out.println(category);
    	System.out.println(title);
    	System.out.println(price);
    	System.out.println(condition);
    	System.out.println(place);
    	System.out.println(exchange);
    	System.out.println(count);
    	System.out.println(content);
	}

}
