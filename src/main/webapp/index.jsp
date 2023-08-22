<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/index.css">
<title>메인페이지</title>
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
				<a href="/content/details.html"> <img
					src="/resources/img/mollect/vanner.png" width="1200px"></a>
			</div>
			<div id="main-layer2">
				<h3>통합 인기 순위</h3>
				<img src="/resources/img/popularity/popularity1.jpeg" width="250px">
				<img src="/resources/img/popularity/popularity2.jpg" width="250px">
				<img src="/resources/img/popularity/popularity3.jpg" width="250px">
				<img src="/resources/img/popularity/popularity4.jpg" width="250px">
			</div>
		</div>

		<div id="footer"></div>
	</div>
</body>
</html>