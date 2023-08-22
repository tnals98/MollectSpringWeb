<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/mypage.css">
<title>회원가입</title>
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
				<h3>회원가입</h3>
			</div>
			<div id="main-layer2">
				<h4>회원정보를 입력하세요</h4>
				<form action="/member/register.do" method="post">
				<fieldset>
					<legend>회원가입</legend>
					<ul>
						<li>
							<label>아이디 : </label>
							<input id="memberId" name="memberId" type="text" placeholder="아이디를 입력해 주세요."><br>	
						</li>
						<li>
							<label>비밀번호 : </label>
							<input id="memberPw" name="memberPw" type="password" placeholder="비밀번호를 입력해 주세요."><br>
						</li>
						<li>
							<label>이름 : </label>
							<input id="memberName" name="memberName" type="text" placeholder="이름을 입력해 주세요."><br>
						</li>
						<li>
							<label>연락처 : </label>
							<input id="memberPhone" name="memberPhone" type="text" placeholder="연락처를 입력해 주세요."><br>
						</li>
						<li>
							<label>이메일 : </label>
							<input id="memberEmail" name="memberEmail" type="text" placeholder="이메일을 입력해 주세요."><br>
						</li>
						<li>
							<label>나이 : </label>
							<input id="memberAge" name="memberAge" type="text" placeholder="나이를 입력해 주세요."><br>
						</li>
						<li>
							<label>성별</label>
							<input id="memberGender" type="radio" name="memberGender" value="male">남
							<input id="memberGender" type="radio" name="memberGender" value="female">여<br>
						</li>
					</ul>
					<input type="submit" value="회원가입">
				</fieldset>
				</form>
			</div>
		</div>


		<div id="footer"></div>
	</div>
</body>
</html>