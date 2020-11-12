package pubsub.publisher;

import pubsub.pojo.Message;
import pubsub.service.PubSubService;

public interface Publisher {
    void publish(Message message, PubSubService service);
}
