package kr.co.mollect.notice.service;

import java.util.List;
import java.util.Map;

import kr.co.mollect.notice.domain.Notice;
import kr.co.mollect.notice.domain.PageInfo;

public interface NoticeService {
 
	// 게시글 등록
	int insertNotice(Notice notice);
	
	// 게시글 수정
	int modifyNotice(Notice notice);

	// 게시글 삭제
	int eraseNotice(String noticeNo);

	// 게시글 전체 갯수 조회
	int getListCount();
	
	// 게시글 목록 조회
	List<Notice> selectNoticeList(PageInfo pInfo);
	
	// 게시글 번호로 조회
	Notice selectNoticeByNo(Integer noticeNo);

	// 게시글 키워드 검색
	List<Notice> searchNoticesByKeyword(PageInfo pInfo, Map<String, String> paramMap);

	// 검색 게시글 전체 갯수
	int getListCount(Map<String, String> paramMap);

}
