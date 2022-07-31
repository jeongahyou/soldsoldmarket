package com.soldsoldMarket.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soldsoldMarket.product.model.service.ProductService;
import com.soldsoldMarket.product.model.vo.Product;

@WebServlet("/product/update")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductUpdateServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// �α��� üũ & ���� �Խñ� ���� Ȯ�� (���� ����)
    	Product product = null;
    	int no = Integer.parseInt(request.getParameter("no"));
    	
    	System.out.println("�Խñ� ��ȣ : " + no);
    	
    	product = new ProductService().getProductByNo(no);
    	
    	System.out.println(product);
    
    	request.setAttribute("product", product);
    	request.getRequestDispatcher("views/product/update.jsp").forward(request, response);
    }
    

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
