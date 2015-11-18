package com.devms.blog.member.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.devms.blog.member.model.TN_Member;

//public interface MemberDAO extends JpaRepository<Tn_member, Integer>{ // JPA Repository 상속시고 아래는 CRUD
public interface MemberDAO extends CrudRepository<TN_Member, Long>{	
	/*
	 @Query("select u from tn_member u where u.id = ?1")
	 List<Tn_member> selectMemberById (@Param("id")String id);
	*/
	List<TN_Member> findById(String id);
	
}
 