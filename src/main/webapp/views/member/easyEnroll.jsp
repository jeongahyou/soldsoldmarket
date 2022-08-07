<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
<c:set var = "path" value = "${pageContext.request.contextPath}"/>    
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>

	<script src="${ path }/resources/js/jquery-3.6.0.js"></script>
	<link rel="stylesheet" type="text/css" href="${path }/resources/css/enroll.css">

</head>
<body>


    <div id="wrap01">
    <div id="header01"></div>

    <div id="content01">
            <img src="${path }/resources/images/로고.png" id="img01">

            <form id="enrollForm" action="${path }/enroll2" method="post">
                    <input type="text" name="enrollId" id="enrollId" value='${member.id}' readonly>
                    <br>
                    <input type="text" name="enrollName" id="enrollName" value='${member.name}' readonly>
                    <br>
                    <input type="text" name="enrollAdress" id="enrollAdress" placeholder="주소">
                    <br>
                    <input type="text" name="enrollBY" id="birthYear" placeholder="년(4자)" >
                    <select id="birthMonth" name="enrollBM" style="height: 45px;">
                        <option selected>===월===</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                    <input type="text" id="birthDay" name="enrollBD" placeholder="일">
                    <br>
                    <select name="enrollGender" style="height: 45px;">
                        <option selected>===성별===</option>
                        <option value="M">남자</option>
                        <option value="F">여자</option>
                    </select>
                    <br>
                    <input type="tel" name="enrollPhone" id="enrollPhone" placeholder="(예시))010-1234-5678">
                    <br>
					<input type="submit" id="enrollbtn" value="카카오로 회원가입" style="background-color: #F7E600; color: #3A1D1D;">        
					    </form>
	    </div>
	</div>
	

            <jsp:include page="/views/common/footerSk.jsp" />

<script type="text/javascript">

let btn = document.getElementById('enrollbtn');
btn.addEventListener('click',function(event){
	
    let name = document.getElementById('enrollName').value;
    let phone = document.getElementById('enrollPhone').value;
    let by = document.getElementById('birthYear').value;
    let bd = document.getElementById('birthDay').value;
	
	
	
	
	
 if(!/^[0-9]{3}-[0-9]{3,4}-[0-9]{3,4}$/.test(phone)){
    alert('휴대폰 번호를 확인하세요');
    //메소드 방식에서는 아래와같이 이벤트를 제거해야 한다.
    event.preventDefault();
}else if(!/^[0-9]{4}$/.test(by)){
    alert('생년을 확인하세요');
    //메소드 방식에서는 아래와같이 이벤트를 제거해야 한다.
    event.preventDefault();
}else if(bd>31 || bd <= 0){
    alert('생일를 확인하세요');
    //메소드 방식에서는 아래와같이 이벤트를 제거해야 한다.
    event.preventDefault();
}

})
	
	</script>
    
</body>
</html>