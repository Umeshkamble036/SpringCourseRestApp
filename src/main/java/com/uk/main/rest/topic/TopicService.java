package com.uk.main.rest.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopic() {

		List<Topic> cList = new ArrayList<Topic>();
		topicRepository.findAll().forEach(cList::add);
		return cList;
	}

	public Optional<Topic> getTopic(int id) throws Exception {
		try {
			return topicRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void addTopic(Topic Topic) {
		try {
			topicRepository.save(Topic);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public void updateTopic(Topic topic, int id) {
		try {
			topicRepository.save(topic);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public void deleteTopic(int id) {

		try {
			topicRepository.deleteById(id);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
