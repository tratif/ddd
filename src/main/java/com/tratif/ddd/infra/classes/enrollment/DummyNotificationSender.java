package com.tratif.ddd.infra.classes.enrollment;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.tratif.ddd.domain.classes.enrollment.BanNotificationSender;

@Component
public class DummyNotificationSender implements BanNotificationSender {

	@Override
	public void notifyAboutBan(Long memberId, LocalDateTime bannedTo) {
		System.out.println("Sending ban notification to member " + memberId + ", banned to: " + bannedTo);
	}
}
