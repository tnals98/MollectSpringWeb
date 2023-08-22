package kr.co.mollect.notice.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.mollect.notice.domain.Notice;
import kr.co.mollect.notice.domain.PageInfo;
import kr.co.mollect.notice.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService service;
	
	@RequestMapping(value="/notice/insert.do", method=RequestMethod.GET)
	public String showInsertForm() {
		return "notice/insert";
	}
	
	@RequestMapping(value="notice/insert.do", method=RequestMethod.POST)
	public String insertNotice(
			@ModelAttribute Notice notice
			, @RequestParam(value = "uploadFile", required=false) MultipartFile uploadFile
			, HttpServletRequest request
			, Model model) {
		try {
			if(!uploadFile.getOriginalFilename().equals("")) {
				String fileName = uploadFile.getOriginalFilename();
				String root = request.getSession().getServletContext().getRealPath("resources");
				String saveFolder = root + "\\nuploadFiles";
				File folder = new File(saveFolder);
				if(!folder.exists()) {
					folder.mkdir();
				}
				String savePath = saveFolder + "\\" + fileName;
				File file = new File(savePath);
				uploadFile.transferTo(file);
				long fileLength = uploadFile.getSize();
				notice.setNoticeFilename(fileName);
				notice.setNoticeFilepath(savePath);
				notice.setNoticeFilelength(fileLength);
			}
			int result = service.insertNotice(notice);
			if(result > 0) {
				return "redirect:/notice/list.do";
			}else {
				model.addAttribute("msg","게시글 작성 실패");
				model.addAttribute("url", "/notice/list.do");
				return "common/errorPage";				
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/notice/list.do", method=RequestMethod.GET)
	public String showNoticeList(
			@RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
			, Model model) {
		try {
			int totalCount = service.getListCount();
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			List<Notice> nList = service.selectNoticeList(pInfo);
			if(nList.size() > 0) {
				model.addAttribute("pInfo", pInfo);
				model.addAttribute("nList", nList);
				return "notice/list";				
			}else {
				model.addAttribute("msg","게시글 목록 조회 실패");
				model.addAttribute("url", "/notice/list.do");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}

	private PageInfo getPageInfo(Integer currentPage, int totalCount) {
		PageInfo pi = null;
		int recordCountPerPage = 10;
		int naviCountPerPage = 10;
		int naviTotalCount;
		int startNavi;
		int endNavi;
		
		naviTotalCount = (int)((double)totalCount/recordCountPerPage+0.9);
		startNavi = (((int)((double)currentPage/naviCountPerPage+0.9))-1)*naviCountPerPage + 1;
		endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		pi = new PageInfo(currentPage, recordCountPerPage, naviCountPerPage, startNavi, endNavi, totalCount, naviTotalCount);
		return pi;
	}

	@RequestMapping(value="/notice/search.do", method=RequestMethod.GET)
	public String searchNoticeList(
			@RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchKeyword") String searchKeyword
			, @RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
			, Model model) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchKeyword", searchKeyword);
		int totalCount = service.getListCount(paramMap);
		PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
		List<Notice> searchList = service.searchNoticesByKeyword(pInfo, paramMap);
		if(!searchList.isEmpty()) {
			model.addAttribute("searchCondition", searchCondition);
			model.addAttribute("searchKeyword", searchKeyword);
			model.addAttribute("pInfo", pInfo);
			model.addAttribute("sList", searchList);
			return "notice/search";
		}else {
			model.addAttribute("msg","게시글 검색 실패");
			model.addAttribute("url", "/notice/list.do");
			return "common/errorPage";			
		}
	}
	
	@RequestMapping(value="/notice/erase.do", method=RequestMethod.GET)
	public String eraseNotice(
			@RequestParam("noticeNo") String noticeNo
			, Model model) {
		try {
			int result = service.eraseNotice(noticeNo);
			if(result > 0) {
				return "redirect:/notice/list.do";
			}else {
				model.addAttribute("msg","게시글 삭제 실패");
				model.addAttribute("url", "/notice/list.do");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="notice/modify.do", method=RequestMethod.POST)
	public String modifyNotice(@ModelAttribute Notice notice, Model model) {
		try {
			int result = service.modifyNotice(notice);
			if(result > 0) {
				return "redirect:/index.jsp";
			}else {
				model.addAttribute("msg", "게시글 수정 실패");
				model.addAttribute("url","/notice/list.do");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="notice/detail.do", method=RequestMethod.GET)
	public String showMyNotice(
			@RequestParam("noticeNo") String noticeNo
			,Model model) {
		try {
			Notice notice = service.getNoticeByNo(noticeNo);
			if(notice != null) {
				model.addAttribute("notice",notice);
				return "notice/detail";
			}else {
				model.addAttribute("msg", "게시글 조회 실패");
				model.addAttribute("url","/notice/list.do");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}
}
