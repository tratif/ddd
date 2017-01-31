package com.tratif.ddd.domain.classes.enrollment;

import java.time.LocalDateTime;

public interface BanNotificationSender {

	void notifyAboutBan(Long memberId, LocalDateTime bannedTo);
	
}
