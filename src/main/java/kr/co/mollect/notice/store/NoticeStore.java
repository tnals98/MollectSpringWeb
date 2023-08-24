package kr.co.mollect.notice.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.mollect.notice.domain.Notice;
import kr.co.mollect.notice.domain.PageInfo;

public interface NoticeStore {
	
	// 게시글 등록
	int insertNotice(SqlSession session, Notice notice);
	
	// 게시글 수정
	int modifyNotice(SqlSession session, Notice notice);
	
	// 게시글 삭제
	int eraseNotice(SqlSession session, String noticeNo);
	
	// 게시글 전체 갯수 조회
	int getListCount(SqlSession session);
	
	// 게시글 목록 조회
	List<Notice> selectNoticeList(SqlSession session, PageInfo pInfo);
	
	// 게시글 번호로 조회
	Notice selectNoticeByNo(SqlSession session, Integer noticeNo);
	
	// 게시글 키워드 검색
	List<Notice> searchNoticesByKeyword(SqlSession session, PageInfo pInfo, Map<String, String> paramMap);
	
	// 검색 게시글 전체 갯수
	int getListCount(SqlSession session, Map<String, String> paramMap);

}
