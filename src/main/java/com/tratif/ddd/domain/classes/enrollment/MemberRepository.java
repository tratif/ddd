package com.tratif.ddd.domain.classes.enrollment;

public interface MemberRepository {

	Member findById(Long id);

	void save(Member member);
}
