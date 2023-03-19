package com.esd.test;

import java.util.List;

import com.esd.dao.NoticeDAO;
import com.esd.pojo.Notice;

public class Tester {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoticeDAO pdao = new NoticeDAO();
		List<Notice> notices = pdao.list();
		
		for (var n : notices)
			System.out.println(n.getTitle());
		
		System.out.println("all notices");
	}
}
