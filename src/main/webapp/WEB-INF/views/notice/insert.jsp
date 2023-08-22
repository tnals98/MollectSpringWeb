<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/insert.css">
<title>문의하기</title>
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
				<h3>1:1 문의</h3>
			</div>
			<div id="main-layer2">
		<form action="/notice/insert.do" method="post" enctype="multipart/form-data">
			<ul>
				<li>
					<label>제목</label>
					<input type="text" id="noticeSubject" name="noticeSubject">
				</li>
				<li>
					<label>작성자</label>
					<input type="text" id="noticeWriter" name="noticeWriter">
				</li>
				<li>
					<label>내용</label><br>
					<textarea rows="20" cols="60" id="noticeContent"name="noticeContent"></textarea>
				</li>
				<li>
					<label>첨부파일</label>
					<input type="file" id="uploadFile" name="uploadFile">
				</li>
			</ul>
				<button type="submit">작성하기</button>
				<button type="reset">초기화</button>
				</form>
			</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>