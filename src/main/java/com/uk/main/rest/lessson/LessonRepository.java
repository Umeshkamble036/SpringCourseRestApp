/**
 * 
 */
package com.uk.main.rest.lessson;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Umesh
 *
 */
public interface LessonRepository extends JpaRepository<Lesson, Integer> {
	
	public List<Lesson> findByCourseId(int courseId);

}
