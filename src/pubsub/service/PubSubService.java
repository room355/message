package pubsub.service;

import pubsub.pojo.Message;
import pubsub.subscriber.Subscriber;

import java.util.*;

public class PubSubService {
    private final Map<String, Set<Subscriber>> subscriberTopicMap;
    private final Queue<Message> queue;

    public PubSubService() {
        subscriberTopicMap = new HashMap<>();
        queue = new LinkedList<>();
    }

    public void addSubscriber(String topic, Subscriber subscriber) {
        if (!subscriberTopicMap.containsKey(topic)) {
            subscriberTopicMap.put(topic, new HashSet<>());
        }
        Set<Subscriber> subscribers = subscriberTopicMap.get(topic);
        subscribers.add(subscriber);
        subscriberTopicMap.put(topic, subscribers);
    }

    public void removeSubscriber(String topic, Subscriber subscriber) {
        if (subscriberTopicMap.containsKey(topic)) {
            subscriberTopicMap.get(topic).remove(subscriber);
        }
    }

    public void addMessage(Message message) {
        this.queue.offer(message);
    }

    public void broadcast() {
        while (!queue.isEmpty()) {
            Message message = queue.poll();
            String topic = message.getTopic();
            Set<Subscriber> subscribers = subscriberTopicMap.get(topic);
            if (!subscriberTopicMap.containsKey(topic)) continue;
            for (Subscriber subscriber : subscribers) {
                List<Message> subscriberMessages = subscriber.getSubscriberMessages();
                subscriberMessages.add(message);
                subscriber.setSubscriberMessages(subscriberMessages);
            }
        }
    }
}
