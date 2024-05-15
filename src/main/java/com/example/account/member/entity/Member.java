package com.example.account.member.entity;

import com.example.account.util.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members")
public class Member extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "user_id", nullable = false)
	private String userId;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "phone", nullable = false)
	private String phone;

}
