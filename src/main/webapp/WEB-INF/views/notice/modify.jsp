<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/modify.css">
<title>문의사항 수정</title>
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

			<div id="main">
				<div id="main-layer1">
					<h3>문의사항 수정</h3>
				</div>
				<div id="main-layer2">
					<form type="/notice/modify.do" method="post" enctype="multipart/form-data">
						<fieldset>
							<ul>
								<li><label>제목</label> <input type="text" id="noticeSubject"
									name="noticeSubject" value="${notice.noticeSubject }"></li>
								<li><label>작성자</label>
								<span>${notice.noticeWriter }</span></li>
								<li><label>내용</label><br> <textarea rows="20"
										cols="40" id="noticeContent" name="noticeContent">${notice.noticeContent }</textarea></li>
								<li><label>첨부파일</label> <input type="file" id="uploadFile"
									name="uploadFile">${notice.noticeFilename }</li>
							</ul>
							<button type="submit">수정하기</button>
							<button type="reset">초기화</button>
						</fieldset>
					</form>
				</div>
			</div>
			<div id="footer"></div>


		</div>
	</div>

</body>
</html>