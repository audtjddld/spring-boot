package com.devms.blog.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devms.blog.member.model.TN_Member;
import com.devms.blog.member.repository.MemberDAO;


@RestController
public class MemberController {
	
	@Autowired
	private MemberDAO memberDAO; 
	 
	/**
	 * 멤버 테이블 조회
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/member/list")
	public Iterable<TN_Member> selectAllMemberList(ModelMap modelMap, @ModelAttribute TN_Member vo) throws Exception{
		
		Iterable<TN_Member> memberList = null;
		
					if(vo.getId() != null){
						memberList = memberDAO.findById(vo.getId());
					}else{
						memberList = memberDAO.findAll();
					}
					
			
			return memberList;
	}
	
	/**
	 * 멤버 정보 저장
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/member/add")
	public TN_Member insertMemberInfo(@ModelAttribute TN_Member vo){
		
			TN_Member member = memberDAO.save(vo);
			
			return vo;
	}
	
}
