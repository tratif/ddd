package com.tratif.ddd.infra.classes.enrollment;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tratif.ddd.domain.classes.enrollment.Class;
import com.tratif.ddd.domain.classes.enrollment.ClassRepository;

public interface SpringDataClassRepository extends ClassRepository, JpaRepository<Class, Long> {


	@Query("select c from Class c where id = 1")
	Class findNearestForMember(Long memberId, LocalDateTime notFarerThan);
}
