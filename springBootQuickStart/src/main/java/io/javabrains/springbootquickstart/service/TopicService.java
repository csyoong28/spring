package io.javabrains.springbootquickstart.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.javabrains.springbootquickstart.model.Topic;

@Service
public class TopicService {
	private List<Topic> topics = Arrays.asList(new Topic("spring", "springframework", "springframework desc"),
			new Topic("java", "core java", "core java desc"),
			new Topic("javascript", "core javascript", "core javascript desc"));

	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}
}
