package com.devms.blog.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devms.blog.member.model.Tn_member;
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
	public Iterable<Tn_member> selectAllMemberList(ModelMap modelMap, @ModelAttribute Tn_member vo) throws Exception{
		Iterable<Tn_member> memberList = null;
		
			try{
					if(vo.getId() != null){
						memberList = memberDAO.findById(vo.getId());
					}else{
						memberList = memberDAO.findAll();
					}
					

			}catch(Exception e){
				e.printStackTrace();
			}

			
			return memberList;
	}
	
	/**
	 * 멤버 정보 저장
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/member/add")
	public Tn_member insertMemberInfo(Tn_member vo){
		
			//Tn_member member = memberDAO.save(vo);
			
			return vo;
	}
	
}
