package com.esd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.esd.dao.StudentDAO;
import com.esd.exception.StudentException;
import com.esd.pojo.Student;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StudentController {
	
	public static int checkSessionValididty(HttpServletRequest request)  {
		if(request.getSession().getAttribute("studlogin")==null) {
			return 1;
		}
		else 
			return 0;
	}
	
	@GetMapping("/")
	public String defaultGet() {
		return "studlogin";
	}
	
	@GetMapping("/studlist.htm")
	public String studDirGet(HttpServletRequest request, StudentDAO studentdao) {
		
		if(checkSessionValididty(request)==1) {
			request.setAttribute("showErr", "You got logged out. Request to login again.");
			return "errlogin";
		}
		
		request.setAttribute("StudList", studentdao.list());

		return "studlist";
	}
	
	@GetMapping("/studlogin.htm")
	public String studLoginGet() {
		return "studlogin";
	}
	
	@GetMapping("/studlgout.htm")
	public String LogOut(HttpServletRequest request) throws Exception {
		request.getSession().invalidate();
		return "studlogin";
	}
	
	@GetMapping("/main.htm")
	public String studMainGet(HttpServletRequest request) {
		
		if(checkSessionValididty(request)==1) {
			request.setAttribute("showErr", "You got logged out. Request to login again.");
			return "errlogin";
		}
		
		if(((Student)request.getSession().getAttribute("studlogin")).isAdminstu())
			return "mainadm";
		else
			return "main";
	}
		
	@PostMapping("/main.htm")
	public String studLoginPost(HttpServletRequest request, StudentDAO studentdao) {
		String eid = request.getParameter("eid");
		String passwd = request.getParameter("passwd");
		
		Student studlogin = studentdao.checkStudLogin(eid,passwd);
		
		if(studlogin == null) {
			request.setAttribute("showErr", "EmailID & Pwd Combination is Incorrect");
			return "errlogin";
		}
		
		request.getSession().setAttribute("studlogin",studlogin);
		
		if(studlogin.isAdminstu())
			return "mainadm";
		else
			return "main";
	}

	@GetMapping("/createstud.htm")
	public String addStudGet(ModelMap model, Student student, HttpServletRequest request) {
		if(checkSessionValididty(request)==1) {
			request.setAttribute("showErr", "You got logged out. Request to login again.");
			return "errlogin";
		}
		
		model.addAttribute("student", student);

		if(((Student)request.getSession().getAttribute("studlogin")).isAdminstu())
			return "studadd";
		else
			return "main";
		
	}

	@PostMapping("/createstud.htm")
	public String addStudPost(@ModelAttribute("student") Student student, BindingResult result, SessionStatus status, 
			StudentDAO studentdao, HttpServletRequest request) {
		
		if(checkSessionValididty(request)==1) {
			request.setAttribute("showErr", "You got logged out. Request to login again.");
			return "errlogin";
		}
		
		Student studadd = studentdao.checkStud(student.getEid());
		
		if(studadd != null) {
			request.setAttribute("Dialogue", "Entered Email ID already exists");
			return "viewresp";
		}
		
		if(student.getPasswd().trim().equals("")) {
			request.setAttribute("Dialogue", "Can't accept empty passwords");
			return "viewresp";
		}		
		
		if(student.getEid().trim().equals("")) {
			request.setAttribute("Dialogue", "Can't accept empty EmailID's");
			return "viewresp";
		}
		
		try {
			studentdao.save(student);
			request.setAttribute("Dialogue", "Student Added");
		} catch (StudentException e) {
			System.out.println("Can't Add Student: " + e.getMessage());
			request.setAttribute("Dialogue", "Can't Add Student");
		}
		
		status.setComplete();
		return "viewresp";
	}
	
	@GetMapping("/modifystud.htm")
	public String studUpdateGet(HttpServletRequest request) {
		if(checkSessionValididty(request)==1) {
			request.setAttribute("showErr", "You got logged out. Request to login again.");
			return "errlogin";
		}
		return "studmodify";
	}
	
	@PostMapping("/modifystud.htm")
	public String studUpdatePost(HttpServletRequest request, StudentDAO studentdao, SessionStatus status) {
		
		if(checkSessionValididty(request)==1) {
			request.setAttribute("showErr", "You got logged out. Request to login again.");
			return "errlogin";
		}
		
		String eidchange = request.getParameter("eidchange");
		String adminstuchange = request.getParameter("adminstuchange");
		String firstnamechange = request.getParameter("firstnamechange");
		String lastnamechange = request.getParameter("lastnamechange");
		String passwdchange = request.getParameter("passwdchange");
		
		String changedeid = request.getParameter("changedeid");
		String changedadminstu = request.getParameter("changedadminstu");
		String changedfirstname = request.getParameter("changedfirstname");
		String changedlastname = request.getParameter("changedlastname");
		String changedpasswd = request.getParameter("changedpasswd");
		
		String eid= request.getParameter("eid");
			
		Student studmodify = studentdao.checkStud(eid);
		
		Student currentStud = ((Student)request.getSession().getAttribute("studlogin"));
		
		if(studmodify == null) {
			request.setAttribute("Dialogue", "Entered Email ID is not correct");
			return "viewresp";
		}
		
		else if(!eid.equals(currentStud.getEid()) && !currentStud.isAdminstu()) {
			request.setAttribute("Dialogue", "Regular students can't modify other student records");
			return "viewresp";
		}
			
		if(eidchange.equals("Yes"))
			studmodify.setEid(changedeid);
		if(adminstuchange.equals("Yes"))
			studmodify.setAdminstu(changedadminstu.equals("Admin"));		
		if(firstnamechange.equals("Yes"))
			studmodify.setFirstname(changedfirstname);
		if(lastnamechange.equals("Yes"))
			studmodify.setLastname(changedlastname);
		if(passwdchange.equals("Yes"))
			studmodify.setPasswd(changedpasswd);		
		
			try {
				studentdao.update(studmodify);
				request.setAttribute("Dialogue", "Student data has been Modified");
			} catch (StudentException e) {
				System.out.println("Student can't be Modified: " + e.getMessage());
				request.setAttribute("Dialogue", "Student can't be Modified");
			}
			
			status.setComplete(); 	
			
		return "viewresp";	
	}
	
	@GetMapping("/removestud.htm")
	public String deleteStudGet(ModelMap model, Student student, HttpServletRequest request) {
		
		if(checkSessionValididty(request)==1) {
			request.setAttribute("showErr", "You got logged out. Request to login again.");
			return "errlogin";
		}
		

		model.addAttribute("student", student);

		if(((Student)request.getSession().getAttribute("studlogin")).isAdminstu())
			return "studremove";
		else
			return "main";
	}

	@PostMapping("/removestud.htm")
	public String deleteStudPost(@ModelAttribute("student") Student student, BindingResult result, SessionStatus status, 
			StudentDAO studentdao, HttpServletRequest request) {
		
		if(checkSessionValididty(request)==1) {
			request.setAttribute("showErr", "You got logged out. Request to login again.");
			return "errlogin";
		}
		
		Student studremove = studentdao.checkStud(student.getEid());
		
		if(studremove == null) {
			request.setAttribute("Dialogue", "Entered Email ID is not correct");
			return "viewresp";
		}
		
		try {
			studentdao.delete(studremove);
			request.setAttribute("Dialogue", "Student Deleted");
		} catch (StudentException e) {
			System.out.println("Can't Delete the Student: " + e.getMessage());
			request.setAttribute("Dialogue", "Can't Delete the Student");
		}
		
		status.setComplete();
		return "viewresp";
	}
	
}