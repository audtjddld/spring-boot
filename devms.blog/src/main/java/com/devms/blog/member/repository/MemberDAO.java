package com.devms.blog.member.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.devms.blog.member.model.Tn_member;

//public interface MemberDAO extends JpaRepository<Tn_member, Integer>{ // JPA Repository 상속시고 아래는 CRUD
public interface MemberDAO extends CrudRepository<Tn_member, Long>{	
	/*
	 @Query("select u from tn_member u where u.id = ?1")
	 List<Tn_member> selectMemberById (@Param("id")String id);
	*/
	List<Tn_member> findById(String id);
	
}
 