package com.tratif.ddd.web.classes.enrollment;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ImposeBanDto {

	@NotNull
	@Min(1)
	private int banDurationInDays;

	public int getBanDurationInDays() {
		return banDurationInDays;
	}
	
}
