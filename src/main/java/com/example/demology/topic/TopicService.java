package com.example.demology.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(

            new Topic("spring", "Muteba", "The Genocider"),
            new Topic("java", "Belwas", "Strongest of the Queensguard"),
            new Topic("boot", "Moqorro", "The Black Flame")
        ));

    public List<Topic> getAllTopics() {

        return topics;
    }

    // Filter by id and take the first id that match
    public Topic getTopic(String id) {

        return topics.stream()
            .filter(t -> t.getId().equals(id))
            .findFirst()
            .get();
    }

    // Adding a topic
    public void addTopic(Topic topic) {

        topics.add(topic);
    }

    // Updating a topic
    public void updateTopic(String id, Topic topic) {

        for (int i = 0; i < topics.size(); i++) {

            Topic t = topics.get(i);
            if (t.getId().equals(id)) {
                
                topics.set(i, topic);
                return;
            }
        }
    }

    // Deleting a topic
    public void deleteTopic(String id) {

        topics.removeIf(t -> t.getId().equals(id));
    }
}
