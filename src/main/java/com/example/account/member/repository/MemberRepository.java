package com.example.account.member.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.account.member.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
