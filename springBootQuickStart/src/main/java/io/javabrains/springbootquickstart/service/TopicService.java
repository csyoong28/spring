package io.javabrains.springbootquickstart.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootquickstart.model.Topic;
import io.javabrains.springbootquickstart.repository.TopicRepository;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("spring", "springframework", "springframework desc"),
			new Topic("java", "core java", "core java desc"),
			new Topic("javascript", "core javascript", "core javascript desc")));

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topicRepository.findOne(id);
		//this is for used with List<Topic> topics above, when not connect to DB
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
		//this is for used with List<Topic> topics above, when not connect to DB
		/*for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}*/	
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
		//this is for used with List<Topic> topics above, when not connect to DB
		//topics.removeIf(t -> t.getId().equals(id));
	}

	public TopicRepository getTopicRepository() {
		return topicRepository;
	}

	public void setTopicRepository(TopicRepository topicRepository) {
		this.topicRepository = topicRepository;
	}
}
