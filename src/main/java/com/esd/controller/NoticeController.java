package com.esd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.esd.dao.NoticeDAO;
import com.esd.exception.StudentException;
import com.esd.pojo.Notice;
import com.esd.pojo.Student;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class NoticeController {
	@GetMapping("/listnotice.htm")
	public String viewNoticeGet(HttpServletRequest request, NoticeDAO noticedao) {
		
		if(StudentController.checkSessionValididty(request)==1) {
			request.setAttribute("showErr", "You got logged out. Request to login again.");
			return "errlogin";
		}
		
		request.setAttribute("Notices", noticedao.list());

		return "viewnotice";
	}
	
	@GetMapping("/createnotice.htm")
	public String addNoticeGet(ModelMap model, Notice notice, HttpServletRequest request) {
		
		if(StudentController.checkSessionValididty(request)==1) {
			request.setAttribute("showErr", "You got logged out. Request to login again.");
			return "errlogin";
		}
		
		model.addAttribute("notice", notice);

		return "noticecreate";
	}

	@PostMapping("/createnotice.htm")
	public String addNoticeNotice(@ModelAttribute("notice") Notice notice, BindingResult result, SessionStatus status, 
			NoticeDAO noticedao, HttpServletRequest request) {
		
		if(StudentController.checkSessionValididty(request)==1) {
			request.setAttribute("showErr", "You got logged out. Request to login again.");
			return "errlogin";
		}
		
		Student u = (Student)request.getSession().getAttribute("studlogin");
		notice.setSid(u);
		try {
			noticedao.save(notice);
			request.setAttribute("Dialogue", "Notice has been Created");
		} catch (StudentException e) {
			System.out.println("Notice can't be Created: " + e.getMessage());
			request.setAttribute("Dialogue", "Notice can't be Created");
		}
		
		status.setComplete(); 
		
		return "viewresp";
	}
	
	@GetMapping("/removenotice.htm")
	public String deleteNoticeGet(ModelMap model, Notice notice, HttpServletRequest request) {
		
		if(StudentController.checkSessionValididty(request)==1) {
			request.setAttribute("showErr", "You got logged out. Request to login again.");
			return "errlogin";
		}
		
		model.addAttribute("notice", notice);

		return "noticeremove";
	}

	@PostMapping("/removenotice.htm")
	public String deleteNoticeNotice(@ModelAttribute("notice") Notice notice, BindingResult result, SessionStatus status, 
			NoticeDAO noticedao, HttpServletRequest request) {
		
		if(StudentController.checkSessionValididty(request)==1) {
			request.setAttribute("showErr", "You got logged out. Request to login again.");
			return "errlogin";
		}
		
		Notice noticeremove = noticedao.checkNotice(notice.getNid());
		
		
		if(noticeremove == null) {
			request.setAttribute("Dialogue", "Entered Notice ID is not correct");
			return "viewresp";
		}
		
		if(noticeremove.getSid().getSid() != ((Student)request.getSession().getAttribute("studlogin")).getSid() && 
				!((Student)request.getSession().getAttribute("studlogin")).isAdminstu()) {
			request.setAttribute("Dialogue", "Regular students can't remove other student notices");
			return "viewresp";
		}
		
		try {
			noticedao.delete(noticeremove);
			request.setAttribute("Dialogue", "Notice has been Removed");
		} catch (StudentException e) {
			System.out.println("Notice can't be Removed: " + e.getMessage());
			request.setAttribute("Dialogue", "Notice can't be Removed");
		}
		
		status.setComplete(); 

		return "viewresp";
	}
		
}