package pubsub.subscriber;

import pubsub.service.PubSubService;

public class SubscriberImpl extends Subscriber {

    @Override
    public void subscribe(String topic, PubSubService service) {
        service.addSubscriber(topic, this);
    }

    @Override
    public void unsubscribe(String topic, PubSubService service) {
        service.removeSubscriber(topic, this);
    }

    @Override
    public void getMessageForSubscriberByTopic(String topic, PubSubService service) {

    }
}
