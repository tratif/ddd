package com.tratif.ddd;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tratif.ddd.domain.classes.enrollment.Member;
import com.tratif.ddd.domain.classes.enrollment.MemberRepository;

@Component
public class DemoBootstrap {

	@Autowired
	MemberRepository memberRepo;

	@PostConstruct
	public void initTestData() {
		memberRepo.save(new Member(UUID.randomUUID(), "Michal"));
	}
}
