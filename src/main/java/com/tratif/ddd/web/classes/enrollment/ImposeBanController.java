package com.tratif.ddd.web.classes.enrollment;

import java.time.Duration;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tratif.ddd.handlers.classes.enrollment.ImposeBanHandler;
import com.tratif.ddd.handlers.classes.enrollment.command.ImposeBan;

@RestController
@RequestMapping("/member")
public class ImposeBanController {

	private final ImposeBanHandler handler;

	@Autowired
	public ImposeBanController(ImposeBanHandler handler) {
		this.handler = handler;
	}

	@PostMapping("/{memberId}/ban")
	@ResponseBody
	public void imposeBan(@PathVariable("memberId") Long memberId, @Valid @RequestBody ImposeBanDto imposeBanDto) {
		handler.handle(new ImposeBan(memberId, Duration.ofDays(imposeBanDto.getBanDurationInDays())));
	}
}
