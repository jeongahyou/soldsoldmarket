<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="product" value="${ list }"/>

<jsp:include page="/views/common/header.jsp" />

<link rel="stylesheet" href="${ path }/resources/css/likelist.css?var=1">

        <!-- ====================================================== -->
        <!-- 본문 -->
        <div class="section">

            <h2>찜한 상품</h2>

            <hr>

            <!-- ====================================================== -->
            <!-- 표 -->
            
            <c:if test="${ empty list }">
	            <br><br><br><br>
	            <h2>찜한 상품이 없습니다.</h2>
	            <br><br><br><br>
            </c:if>
            
            <c:if test="${ not empty list }">       
	            <table class="board_list">
	                <thead>
	                    <tr>
	                        <th>상품 등록 날짜</th>
	                        <th>상품</th>
	                        <th>상품명</th>
	                        <th>가격</th>
	                    </tr>
	                </thead>
	                <tbody>
	                
	                	<c:forEach var="product" items="${ list }">	                	
		                    <tr>
		                        <td class="td1">${ product.PDate }</td>
		                        <td class="td2"><img src="${ path }/resources/upload/product/${ product.PThumb }" alt="이미지"></td>
		                        <td class="td3">
		                            <a href="${path}/product/view?no=${product.PNo}" name="no">${ product.PName }</a>
		                        </td>
		                        <td class="td4"><fmt:formatNumber value="${ product.PPrice }" pattern="#,###" />원</td>
		                    </tr>
	                    </c:forEach>
	                    	
	                </tbody>
	            </table>
           </c:if>


            <!-- ====================================================== -->
            <!-- 페이지 버튼 -->
            <div class="page_wrap">
                <div class="page_nation">
                    <a class="arrow pprev" href="${ path }/mypage/likelist?page=1">&#60;&#60;</a>
                    <a class="arrow prev" href="${ path }/mypage/likelist?page=${ pageInfo.prevPage }">&#60;</a>
                    
			   		<c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" varStatus="status">
						<c:if test="${ status.current == pageInfo.currentPage }">
							<a href="#" class="active">${ status.current }</a>
						</c:if>
						<c:if test="${ status.current != pageInfo.currentPage }">
							<a href="${ path }/mypage/likelist?page=${ status.current }">${ status.current }</a>
						</c:if>
					</c:forEach>
			
                    <a class="arrow next" href="${ path }/mypage/likelist?page=${ pageInfo.nextPage }">&#62;</a>
                    <a class="arrow nnext" href="${ path }/mypage/likelist?age=${ pageInfo.maxPage }">&#62;&#62;</a>
                </div>
            </div>
        </div>
        
        
<jsp:include page="/views/common/footer.jsp" /> 