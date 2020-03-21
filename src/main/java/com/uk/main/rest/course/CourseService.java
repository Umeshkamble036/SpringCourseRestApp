package com.uk.main.rest.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourse(int topicId) {

		List<Course> cList = new ArrayList<Course>();
		courseRepository.findByTopicId(topicId).forEach(cList::add);
		return cList;
	}

	public Optional<Course> getCourse(int id) throws Exception {
		try {
			return courseRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void addCourse(Course course) {
		try {
			courseRepository.save(course);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public void updateCourse(Course course) {
		try {
			courseRepository.save(course);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public void deleteCourse(int id) {

		try {
			courseRepository.deleteById(id);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
