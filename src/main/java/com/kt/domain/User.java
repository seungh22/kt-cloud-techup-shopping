package com.kt.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 1. domain과 entity를 분리해야
// 2. 굳이? 같이쓰지 뭐
@Getter
@NoArgsConstructor
@Entity
public class User {
	// 이 클래스가 controller 역할을 한다는 것을 알려주는 어노테이션 : @Controller, @RestController
	// 똑같이 이 클래스가 Entity야 라고(데이터베이스랑 1:1매칭되는) 알려주는 어노테이션 : @Entity

	// Persistent entity 'User' should have primary key
	// id를 pk로 쓰고 있지만 쓰고 있다는걸 알려줘야 => @ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String loginId;
	private String password;
	private String name;
	private String email;
	private String mobile;
	// enum을 다루는 방식 2가지
	// ordinal : enum의 순서를 DB에 저장 => 절대 사용하지말자
	// string : enum의 값 DB에 저장
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private LocalDate birthday;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public User(String loginId, String password, String name, String mobile, String email, Gender gender,
		LocalDate birthday, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.loginId = loginId;
		this.password = password;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.gender = gender;
		this.birthday = birthday;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public void changePassword(String password) {
		this.password = password;
	}

	public void update(String name, String email, String mobile) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
}
