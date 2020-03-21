package com.uk.main.rest.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uk.main.rest.topic.Topic;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;

	@RequestMapping(method = RequestMethod.GET,value="/topic/{topicId}/course")
	private List<Course> getAllCourses(@PathVariable String topicId) {
		return courseService.getAllCourse(Integer.parseInt(topicId));
	}

	@RequestMapping(method = RequestMethod.GET,value="/topic/{topicId}/course/{courseid}")
	private Optional<Course> getCourse(@PathVariable("courseid") String id) throws NumberFormatException, Exception {
		
		return courseService.getCourse(Integer.parseInt(id));
	}

	@PostMapping("/topic/{topicId}/course")
	private void addCoures(@RequestBody Course course,@PathVariable("topicId") String id) {
		course.setTopic(new Topic(Integer.parseInt(id),"",""));
		courseService.addCourse(course);
	}

	@PutMapping("/topic/{topicId}/course/{courseId}")
	private void updateCoures(@RequestBody Course course,@PathVariable String topicId ,@PathVariable String courseId) {
		course.setTopic(new Topic(Integer.parseInt(topicId),"",""));
		courseService.updateCourse(course);
	}
	
	@DeleteMapping("/topic/{topicId}/course/{courseid}")
	private void deleteCoures(@PathVariable("courseid") String id) {

		courseService.deleteCourse(Integer.parseInt(id));
	}
}
