package com.uk.main.rest.lessson;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	@Autowired
	private LessonRepository lessonRepository;

	public List<Lesson> getAllLesson(int courseId) {

		List<Lesson> lList = new ArrayList<Lesson>();
		lessonRepository.findByCourseId(courseId).forEach(lList::add);
		return lList;
	}

	public Optional<Lesson> getLesson(int id) throws Exception {
		try {
			return lessonRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void addLesson(Lesson lesson) {
		try {
			lessonRepository.save(lesson);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public void updateLesson(Lesson lesson) {
		try {
			lessonRepository.save(lesson);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public void deleteLesson(int id) {

		try {
			lessonRepository.deleteById(id);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
