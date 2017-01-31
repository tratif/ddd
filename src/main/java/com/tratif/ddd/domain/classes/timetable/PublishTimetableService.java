package com.tratif.ddd.domain.classes.timetable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tratif.ddd.domain.classes.enrollment.Class;
import com.tratif.ddd.domain.classes.enrollment.ClassRepository;

@Service
public class PublishTimetableService {

	private TimetableRepository timetableRepository;
	private ClassRepository classRepository;
	
	
	@Autowired
	public PublishTimetableService(TimetableRepository timetableRepo, ClassRepository classRepo) {
		this.timetableRepository = timetableRepo;
		this.classRepository = classRepo;
	}
	
	
	public void publishTimetable(Long timetableId, Period validityPeriod) {
		Timetable timetable = timetableRepository.findById(timetableId);
		
		List<Class> newClasses = timetable.publish(validityPeriod);
		
		newClasses.forEach(newClass -> classRepository.save(newClass));
	}
}
