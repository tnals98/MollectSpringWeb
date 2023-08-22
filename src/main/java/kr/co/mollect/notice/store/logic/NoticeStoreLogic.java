package kr.co.mollect.notice.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.mollect.notice.domain.Notice;
import kr.co.mollect.notice.domain.PageInfo;
import kr.co.mollect.notice.store.NoticeStore;

@Repository
public class NoticeStoreLogic implements NoticeStore{

	@Override
	public int insertNotice(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	@Override
	public int getListCount(SqlSession session) {
		int result = session.selectOne("NoticeMapper.getListCount");
		return result;
	}

	@Override
	public List<Notice> selectNoticeList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = session.selectList("NoticeMapper.selectNoticeList", null, rowBounds);
		return nList;
	}

	@Override
	public int getListCount(SqlSession session, Map<String, String> paramMap) {
		int result = session.selectOne("NoticeMapper.selectNoticesByKeywordCount", paramMap);
		return result;
	}

	@Override
	public List<Notice> searchNoticesByKeyword(SqlSession session, PageInfo pInfo, Map<String, String> paramMap) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> searchList = session.selectList("NoticeMapper.searchNoticesByKeyword", paramMap, rowBounds);
		return searchList;
	}

	@Override
	public int eraseNotice(SqlSession session, String noticeNo) {
		int result = session.delete("NoticeMapper.eraseNotice", noticeNo);
		return result;
	}

	@Override
	public int modifyNotice(SqlSession session, Notice notice) {
		int result = session.update("NoticeMapper.modifyNotice", notice);
		return result;
	}

	@Override
	public Notice getNoticeByNo(SqlSession session, String noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.getNoticeByNo", noticeNo);
		return notice;
	}
	

}
