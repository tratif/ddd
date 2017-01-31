package com.tratif.ddd.infra.classes.enrollment;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tratif.ddd.domain.classes.enrollment.Member;
import com.tratif.ddd.domain.classes.enrollment.MemberRepository;


public interface SpringDataMemberRepository extends MemberRepository, JpaRepository<Member, UUID> {

}
