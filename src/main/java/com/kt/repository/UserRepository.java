package com.kt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kt.domain.User;

// <T, ID>
// T : Entity 클래스 => User
// ID : Entity 클래스의 PK 타입 => Long
public interface UserRepository extends JpaRepository<User, Long> {
	// 여기에 쿼리를 작성해줘야
	// JPA에서는 쿼리를 작성하는 3가지 방법이 존재
	// 1. 네이트브 쿼리 작성 -> "SELECT EXISTS (SELECT id FROM MEMBER WHERE loginId = ?)"
	// 2. JPQL 작성 -> 네이티브 쿼리랑 같은데 Entity 기반 - 너무 길어진 메소드 이름을 그냥 쿼리 작성해서 숨김
	// 3. querymethod 작성 -> 메서드 이름을 쿼리 처럼 작성 - 길어지면 상당히 이상해보임
	// 3-2-1순으로 많이 사용
	// 찾는다 : findByxx , 존재하나? : existsByxx , 삭제 : deleteByxx

	Boolean existsByLoginId(String loginId);

	@Query("""
SELECT exists(SELECT u FROM User u WHERE u.loginId = ?1)
""")
	Boolean existsByLoginIdJPQL(String loginId);

	Page<User> findAllByNameContaining(String name, Pageable pageable);

}
