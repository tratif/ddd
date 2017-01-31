package com.tratif.ddd.domain.classes.enrollment;

import java.time.LocalDateTime;

public interface ClassRepository {

	Class findById(Long id);

	void save(Class clazz);

	Class findNearestForMember(Long memberId, LocalDateTime notFarerThan);
}
