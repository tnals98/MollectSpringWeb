<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/login.css">
<title>로그인</title>
</head>
<body>
	<div id="container">
		<div id="header">
			<div id="header-layer1"></div>
			<div id="header-layer2">
				<ul id="header-top">
					<li><input type="text" id="serch" size="10"> <input
						type="submit" value="검색"></li>
					<li><a href="/notice/list.do">고객센터</a></li>
					<li><a href="/member/login.do">로그인/회원가입</a></li>
					<li><a href="/index.jsp">메인으로</a></li>
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
				<div id="login">
					<c:if test="${memberId ne null }">
					${memberName }님 환영합니다!<br><br><br><br>
					<a href="/member/logout.do">로그아웃</a>
					<a href="/member/mypage.do?memberId=${memberId }">마이페이지</a>
				</c:if>
				<c:if test="${memberId eq null}">
						<form action="/member/login.do" method="post">
							<div id="login-header">
								<div id="login-header-layer1">
									<div id="id-field">
										<input type="text" name="memberId" size="30">
									</div>
									<div id="pw-field">
										<input type="password" name="memberPw" size="30">
									</div>
								</div>
								<div id="login-header-layer2">
									<input type="submit" value="로그인">
								</div>
							</div>
							<div id="login-footer">
								<a href="/member/register.do">회원가입</a> <a href="#">ID/PW 찾기</a>
							</div>
						</form>
					</c:if>
				</div>
				<div id="advertising">
					<img src="/resources/img/mollect/advertising.jpg" width="1200px"
						height="150px">
				</div>
			</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>