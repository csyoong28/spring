package io.javabrains.springbootquickstart.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootquickstart.model.Topic;

@RestController
public class T02_TopicController {
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return Arrays.asList(
				new Topic("spring", "springframework", "springframework desc"),
				new Topic("java", "core java", "core java desc"),
				new Topic("javascript", "core javascript", "core javascript desc"));
	}
}
