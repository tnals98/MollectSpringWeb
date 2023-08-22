package kr.co.mollect.notice.service;

import java.util.List;
import java.util.Map;

import kr.co.mollect.notice.domain.Notice;
import kr.co.mollect.notice.domain.PageInfo;

public interface NoticeService {

	int insertNotice(Notice notice);

	int getListCount();

	List<Notice> selectNoticeList(PageInfo pInfo);

	int getListCount(Map<String, String> paramMap);

	List<Notice> searchNoticesByKeyword(PageInfo pInfo, Map<String, String> paramMap);

	int eraseNotice(String noticeNo);

	int modifyNotice(Notice notice);

	Notice getNoticeByNo(String noticeNo);

}
