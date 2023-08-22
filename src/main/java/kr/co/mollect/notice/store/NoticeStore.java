package kr.co.mollect.notice.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.mollect.notice.domain.Notice;
import kr.co.mollect.notice.domain.PageInfo;

public interface NoticeStore {

	int insertNotice(SqlSession session, Notice notice);

	int getListCount(SqlSession session);

	List<Notice> selectNoticeList(SqlSession session, PageInfo pInfo);

	int getListCount(SqlSession session, Map<String, String> paramMap);

	List<Notice> searchNoticesByKeyword(SqlSession session, PageInfo pInfo, Map<String, String> paramMap);

	int eraseNotice(SqlSession session, String noticeNo);

	int modifyNotice(SqlSession session, Notice notice);

	Notice getNoticeByNo(SqlSession session, String noticeNo);

}
