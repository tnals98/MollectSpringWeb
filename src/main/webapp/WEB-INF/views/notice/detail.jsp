<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/detail.css">
<title>문의사항 상세 조회</title>
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
				<h3>나의 문의</h3>
			</div>
			<div id="main-layer2">
				<ul>
					<li>
						<label>글번호</label>
						<span>${noticeNo }</span>
					</li>
					<li>
						<label>작성일</label>
						<span>${noticeDate }</span>
					</li>
					<li>
						<label>글쓴이</label>
						<span>${noticeWriter }</span>
					</li>
					<li>
						<label>제목</label>
						<span>${noticeSubject }</span>
					</li>
					<li>
						<label>내용</label>
						<p>${noticeContent }</p>
					</li>
				</ul>
				<a href="/notice/list.do"><button id="list">목록으로</button></a>
				<a href="/notice/modify.do?noticeNo=${noticeNo }"><button id="modi">수정하기</button></a>
				<a href="/notice/notice.do?noticeNo=${noticeNo }"><button id="erase">삭제하기</button></a><br>
			</div>
		</div>
		
		
		
		<div id="footer"></div>
	</div>
</body>
</html>