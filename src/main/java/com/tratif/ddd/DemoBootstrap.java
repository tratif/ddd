package com.tratif.ddd;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tratif.ddd.domain.classes.enrollment.ClassRepository;
import com.tratif.ddd.domain.classes.enrollment.Member;
import com.tratif.ddd.domain.classes.enrollment.MemberRepository;


@Component
public class DemoBootstrap {

	@Autowired
	MemberRepository memberRepo;
	
	@Autowired
	ClassRepository classRepo;
	
	@PostConstruct
	public void initTestData() {
		memberRepo.save(new Member("Michal"));
	}
}
