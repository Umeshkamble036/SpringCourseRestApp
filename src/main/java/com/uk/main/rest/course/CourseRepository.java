/**
 * 
 */
package com.uk.main.rest.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Umesh
 *
 */
public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	public List<Course> findByTopicId(int topicId);

}
