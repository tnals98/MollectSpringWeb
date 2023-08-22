<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/update.css">
<title>회원 정보 수정</title>
</head>
<body>
<div id="container">
		<div id="header">
			<div id="header-layer1"></div>
			<div id="header-layer2">
				<ul id="header-top">
					<li><a href="/notice/list.do">고객센터</a></li>
					<li><a href="/member/login.do">로그인/회원가입</a></li>
					<li><a href="/index.jsp">메인으로</a></li>
					<li><input type="text" id="serch"> <input
						type="submit" value="검색"></li>
				</ul>
			</div>
		</div>
		<div id="nav">
			<ul id="menu">
				<li><a href="/content/popularContent.html">인기순위</a></li>
				<li><a href="#">추천</a></li>
				<li><a href="/content/endingContent.html">종료예정작</a></li>
				<li><a href="/member/mypage.do?memberId=${memberId }">마이페이지</a></li>
			</ul>
		</div>


		<div id="main">
			<div id="main-layer1">
				<h3>회원정보수정</h3>
			</div>
			<div id="main-layer2">
				<form action="/member/update.do" method="post">
				<fieldset>
					<legend>회원정보수정</legend>
					<ul>
						<li>
							<label>아이디 : </label>
							<span>${member.memberId }</span>	
						</li>
						<li>
							<label>비밀번호 : </label>
							<input id="memberPw" name="memberPw" type="password"><br>
						</li>
						<li>
							<label>이름 : </label>
							<span>${member.memberName }</span>
						</li>
						<li>
							<label>연락처 : </label>
							<input id="memberPhone"  name="memberPhone" type="text"><br>
						</li>
						<li>
							<label>이메일 : </label>
							<input id="memberEmail"  name="memberEmail" type="text"><br>
						</li>
						<li>
							<label>나이 : </label>
							<span>${member.memberAge }</span>
						</li>
						<li>
							<c:if test="${member.memberGender eq 'M'}"><span>남자</span></c:if>
							<c:if test="${member.memberGender eq 'F'}"><span>여자</span></c:if>
						</li>
					</ul>
					<button type="submit">수정하기</button>
				</fieldset>
				</form>
			</div>
		</div>


		<div id="footer"></div>
	</div>
</body>
</html>