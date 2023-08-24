package kr.co.mollect.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.mollect.member.domain.Member;
import kr.co.mollect.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/member/register.do", method=RequestMethod.GET)
	public String showRegisterForm() {
		return "member/register";
	}
	
	@RequestMapping(value="/member/register.do", method=RequestMethod.POST)
	public String registerMember(
			@ModelAttribute Member member
			, Model model) {
		try {
			int result = service.registerMember(member);
			if(result > 0) {
				return "redirect:/index.jsp";
			}else {
				model.addAttribute("msg", "회원가입 실패");
				model.addAttribute("url", "/index.jsp");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public String showLoginForm() {
		return "/member/login";
	}
	
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String checkMemberLogin(
			@ModelAttribute Member member
			, HttpSession session
			, Model model) {
		try {
			Member mOne = service.checkMemberLogin(member);
			if(mOne != null) {
				session.setAttribute("memberId", mOne.getMemberId());
				session.setAttribute("memberName", mOne.getMemberName());
				return "redirect:/index.jsp";
			}else {
				model.addAttribute("msg", "로그인 실패");
				model.addAttribute("url", "/index.jsp");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/mypage.do", method=RequestMethod.GET)
	public String showMyPage(
			@RequestParam("memberId") String memberId
			, Model model) {
		try {
			Member member = service.getMemberById(memberId);
			if(member != null) {
				model.addAttribute("member", member);
				return "member/mypage";
			}else {
				model.addAttribute("msg", "마이페이지 조회 실패");
				model.addAttribute("url", "/index.jsp");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}

	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public String memberLogout(HttpSession session, Model model) {
		if(session != null) {
			session.invalidate();
			return "redirect:/index.jsp";
		}else {
			model.addAttribute("msg", "로그아웃 실패");
			model.addAttribute("url", "/member/mypage.do");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/update.do", method=RequestMethod.GET)
	public String showUpdateForm(
			String memberId
			, Model model) {
		Member member = service.getMemberById(memberId);
		model.addAttribute("member", member);
		return "member/update";
	}
	
	@RequestMapping(value="/member/update.do", method=RequestMethod.POST)
	public String updateMember(@ModelAttribute Member member, Model model) {
		try {
			int result = service.updateMember(member);
			if(result > 0) {
				return "redirect:/index.jsp";
			}else {
				model.addAttribute("msg","개인정보 수정 실패");
				model.addAttribute("url", "/member/mypage.do?memberId="+member.getMemberId());
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value= "/member/delete.do", method=RequestMethod.GET)
	public String deleteMember(
			@RequestParam("memberId") String memberId
			, Model model) {
		try {
			int result = service.deleteMember(memberId);
			if(result > 0) {
				return "redirect:/member/logout.do";
			}else {
				model.addAttribute("msg","회원 탈퇴 실패");
				model.addAttribute("url", "/member/mypage.do");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}
	
}
