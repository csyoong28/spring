package io.javabrains.springbootquickstart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import io.javabrains.springbootquickstart.model.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, String> {

}
