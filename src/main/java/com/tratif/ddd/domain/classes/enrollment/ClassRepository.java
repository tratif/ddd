package com.tratif.ddd.domain.classes.enrollment;

import java.time.LocalDateTime;
import java.util.UUID;

public interface ClassRepository {

	Class findById(UUID id);

	void save(Class clazz);

	Class findNearestForMember(UUID memberId, LocalDateTime notFarerThan);
}
