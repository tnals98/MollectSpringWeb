package kr.co.mollect.notice.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mollect.notice.domain.Notice;
import kr.co.mollect.notice.domain.PageInfo;
import kr.co.mollect.notice.service.NoticeService;
import kr.co.mollect.notice.store.NoticeStore;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private SqlSession session;
	@Autowired
	private NoticeStore nStore;

	@Override
	public int insertNotice(Notice notice) {
		int result = nStore.insertNotice(session, notice);
		return result;
	}

	@Override
	public int getListCount() {
		int result = nStore.getListCount(session);
		return result;
	}

	@Override
	public List<Notice> selectNoticeList(PageInfo pInfo) {
		List<Notice> nList= nStore.selectNoticeList(session, pInfo);
		return nList;
	}

	@Override
	public int getListCount(Map<String, String> paramMap) {
		int result = nStore.getListCount(session, paramMap);
		return result;
	}

	@Override
	public List<Notice> searchNoticesByKeyword(PageInfo pInfo, Map<String, String> paramMap) {
		List<Notice> searchList = nStore.searchNoticesByKeyword(session, pInfo, paramMap);
		return searchList;
	}

	@Override
	public int eraseNotice(String noticeNo) {
		int result = nStore.eraseNotice(session, noticeNo);
		return result;
	}

	@Override
	public int modifyNotice(Notice notice) {
		int result = nStore.modifyNotice(session, notice);
		return result;
	}

	@Override
	public Notice getNoticeByNo(String noticeNo) {
		Notice notice = nStore.getNoticeByNo(session,noticeNo);
		return notice;
	}

}
