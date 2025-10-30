package com.kt.dto;

import java.time.LocalDate;

import com.kt.domain.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

// bean validation이라는 기능을 통해서 유효성 겁사
public class UserCreateRequest {
	@NotBlank // null 이거나 공백이면 안됨
	String loginId,
	@NotBlank
	// 최소 8자이상 대소문자, 숫자, 특수문자 포함 -> 정규식
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^])[A-Za-z\\d!@#$%^]{8,}$")
	String password,
	@NotBlank
	String name,
	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
	String email,
	@NotBlank
	@Pattern(regexp = "^(0\\d{1,2})-(\\d{3,4})-(\\d{4})$")
	String mobile,
	@NotNull
	Gender gender,  // " ", "남자"->NULL인 경우만 막아주면 됨
	@NotNull
	LocalDate birthday
} {
}
