package pubsub.publisher;

import pubsub.pojo.Message;
import pubsub.service.PubSubService;

public class PublisherImpl implements Publisher {
    @Override
    public void publish(Message message, PubSubService service) {
        service.addMessage(message);
    }
}
