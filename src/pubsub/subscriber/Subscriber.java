package pubsub.subscriber;

import pubsub.pojo.Message;
import pubsub.service.PubSubService;

import java.util.LinkedList;
import java.util.List;

public abstract class Subscriber {
    private List<Message> subscriberMessages = new LinkedList<>();

    public List<Message> getSubscriberMessages() {
        return subscriberMessages;
    }

    public void setSubscriberMessages(List<Message> subscriberMessages) {
        this.subscriberMessages = subscriberMessages;
    }

    public abstract void subscribe(String topic, PubSubService service);
    public abstract void unsubscribe(String topic, PubSubService service);
    public abstract void getMessageForSubscriberByTopic(String topic, PubSubService service);

    public void printMessage() {
        for (Message msg : subscriberMessages) {
            System.out.println(msg.toString());
        }
    }
}
