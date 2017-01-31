package com.tratif.ddd.domain.classes.enrollment;

import java.util.UUID;

public interface MemberRepository {

	Member findById(UUID id);

	void save(Member member);
}
