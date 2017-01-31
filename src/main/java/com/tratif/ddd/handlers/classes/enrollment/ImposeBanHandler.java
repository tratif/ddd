package com.tratif.ddd.handlers.classes.enrollment;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tratif.ddd.domain.classes.enrollment.BanNotificationSender;
import com.tratif.ddd.domain.classes.enrollment.Member;
import com.tratif.ddd.domain.classes.enrollment.MemberRepository;
import com.tratif.ddd.handlers.classes.enrollment.command.ImposeBan;

@Component
@Transactional
public class ImposeBanHandler {

	private MemberRepository memberRepo;
	private BanNotificationSender notificationSender;
	
	@Autowired
	public ImposeBanHandler(MemberRepository memberRepo, BanNotificationSender notificationSender) {
		this.memberRepo = memberRepo;
		this.notificationSender = notificationSender;
	}
	
	public void handle(ImposeBan command) {
		Member member = memberRepo.findById(command.getMemberId());
		
		member.ban(command.getBanDuration());
	}
}
