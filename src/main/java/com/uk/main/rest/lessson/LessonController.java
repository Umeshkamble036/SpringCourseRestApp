package com.uk.main.rest.lessson;

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

import com.uk.main.rest.course.Course;

@RestController
public class LessonController {
	@Autowired
	private LessonService lessonService;

	@RequestMapping(method = RequestMethod.GET,value="/topic/{topicId}/course/{courseId}/lesson")
	private List<Lesson> getAllLessons(@PathVariable String courseId) {
		return lessonService.getAllLesson(Integer.parseInt(courseId));
	}

	@RequestMapping(method = RequestMethod.GET,value="/topic/{topicId}/course/{courseId}/lesson/{lessonId}")
	private Optional<Lesson> getLesson(@PathVariable("lessonId") String id) throws NumberFormatException, Exception {
		
		return lessonService.getLesson(Integer.parseInt(id));
	}

	@PostMapping("/topic/{topicId}/course/{courseId}/lesson")
	private void addCoures(@RequestBody Lesson lesson,@PathVariable String topicId,@PathVariable String courseId) {
		lesson.setCourse(new Course(Integer.parseInt(courseId),"","",Integer.parseInt(topicId)));
		lessonService.addLesson(lesson);
	}

	@PutMapping("/topic/{topicId}/course/{courseId}/lesson/{lessonId}")
	private void updateCoures(@RequestBody Lesson lesson,@PathVariable String topicId,@PathVariable String courseId) {
		lesson.setCourse(new Course(Integer.parseInt(courseId),"","",Integer.parseInt(topicId)));
		lessonService.updateLesson(lesson);
	}
	
	@DeleteMapping("/topic/{topicId}/course/{courseId}/lesson/{lessonId}")
	private void deleteCoures(@PathVariable String lessonId) {

		lessonService.deleteLesson(Integer.parseInt(lessonId));
	}
}
