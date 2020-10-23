package io.javabrains.springbootstarter.topic;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	List<Topic> topics = new ArrayList<Topic>( Arrays.asList(
			new Topic("spring","spring boot","spring boot description"),
			new Topic("Java","Java core","Java core description"),
			new Topic("JavaScript","JavaScript","JavaScript description")
			));
	
	public List<Topic> getAllTopics()
	{
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		Optional<Topic> topic = topics.stream().filter(a->a.getId().equalsIgnoreCase(id)).findFirst();
		Topic top = topic.orElseThrow(()->new NoSuchElementException("cant find this id = "+ id));
		return top;
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}

	public void updateTopic(Topic topic, String id) {
		for(int i=0;i<topics.size();i++)
		{
			if(topics.get(i).getId().equalsIgnoreCase(id))
			{
				topics.set(i, topic);
				break;
			}
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(p->p.getId().equalsIgnoreCase(id));
	}
	
	

}
