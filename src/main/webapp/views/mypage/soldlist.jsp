<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="/views/common/header.jsp" />

<link rel="stylesheet" href="${ path }/resources/css/mypage.css">

    <div class="section">
        <div class="intro_text">
            <table class="information">
				<tr>
                    <td>프로필 사진</td>
                    <td>img</td>
                </tr>            
                <tr>
                    <td>회원아이디 : </td>
                    <td>id</td>
                </tr>
                <tr>
                    <td>신고당한 수 : </td>
                    <td>count</td>
                </tr>
                <tr>
                    <td>주요 거래지역 : </td>
                    <td>area</td>
                </tr>
                <tr>
                    <td>판매횟수 : </td>
                    <td>count</td>
                </tr>
                <tr>
                    <td>방문횟수 : </td>
                    <td>count</td>
                </tr>
                <tr>
                    <td>가입일 : </td>
                    <td>date</td>
                </tr>
                <tr>
                    <td>소개글 : </td>
                    <td>introduce</td>
                </tr>
            </table>
        </div>
    
    <hr>

    <table class="product_list">
        <tr>
            <td>2022-07-24</td>
            <td><img src="../resources/image/flower1.PNG" width="50px" height="50px"></td>
            <td>상품 이름</td>
            <td>판매완료</td>
        </tr>
        <tr>
            <td>2022-07-23</td>
            <td><img src="../resources/image/flower1.PNG" width="50px" height="50px"></td>
            <td>상품 이름</td>
            <td>판매완료</td>
        </tr>
        <tr>
            <td>2022-07-22</td>
            <td><img src="../resources/image/flower1.PNG" width="50px" height="50px"></td>
            <td>상품 이름</td>
            <td>판매완료</td>
        </tr>
    </table>
</div>
<jsp:include page="/views/common/footer.jsp" /> 
