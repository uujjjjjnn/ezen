package com.lec.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lec.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

	List<Member> findByRole(String role);
	List<Member> findByRoleContaining(String role);
	List<Member> findByNameContainingOrRoleContaining(String name, String role);
	// List<Member> findByRoleContainingOrderByMember_idDesc(String string);
	// List<Member> findByRoleContaining(String string, Pageable paging);
	Page<Member> findByRoleContaining(String string, Pageable paging);
	
	@Query("select m from Member m where m.role like %:searchKeyword% order by m.role desc")
	List<Member> queryAnnotation11(@Param("searchKeyword") String string);
	
	@Query("select m.name, m.password, m.role from Member m where m.role like %?1% order by m.role desc")
	List<Object[]> queryAnnotation22(@Param("searchKeyword") String string);
	
	@Query(value= "select member_id, name, password, role from Member m where m.role like '%'||?1||'%' order by role desc", nativeQuery=true)
	List<Object[]> queryAnnotation33(String string);
	
	@Query("select m from Member m")
	List<Member> queryAnnotation44(Pageable paging);

}
