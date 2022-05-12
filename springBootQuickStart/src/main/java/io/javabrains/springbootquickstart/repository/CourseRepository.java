package io.javabrains.springbootquickstart.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.springbootquickstart.model.Course;
import io.javabrains.springbootquickstart.model.Topic;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {
	public List<Course> findByName(String courseName);
	public List<Course> findByDescription(String foo);
	//topic is an entity, can find by the entity's field
	public List<Course> findByTopicId(String topicId);
}
