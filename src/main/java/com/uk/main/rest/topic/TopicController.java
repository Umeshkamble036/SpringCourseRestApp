package com.uk.main.rest.topic;

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

@RestController
public class TopicController {
	@Autowired
	private TopicService TopicService;

	@RequestMapping(method = RequestMethod.GET,value="/topic")
	private List<Topic> getAllTopics() {
		return TopicService.getAllTopic();
	}

	@RequestMapping(method = RequestMethod.GET,value="/topic/{topicId}")
	private Optional<Topic> getTopic(@PathVariable("topicId") String id) throws NumberFormatException, Exception {
		
		return TopicService.getTopic(Integer.parseInt(id));
	}

	@PostMapping("/topic")
	private void addCoures(@RequestBody Topic topic) {

		TopicService.addTopic(topic);
	}

	@PutMapping("/topic/{topicId}")
	private void updateCoures(@RequestBody Topic topic, @PathVariable("topicId") String id) {

		TopicService.updateTopic(topic,Integer.parseInt(id));
	}
	
	@DeleteMapping("/topic/{topicId}")
	private void deleteCoures(@PathVariable("topicId") String id) {

		TopicService.deleteTopic(Integer.parseInt(id));
	}
}
