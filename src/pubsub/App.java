package pubsub;

import pubsub.pojo.Message;
import pubsub.publisher.Publisher;
import pubsub.publisher.PublisherImpl;
import pubsub.service.PubSubService;
import pubsub.subscriber.Subscriber;
import pubsub.subscriber.SubscriberImpl;

public class App {
    public static void main(String[] args) {
        Publisher javaPublisher = new PublisherImpl();
        Publisher pythonPublisher = new PublisherImpl();

        Subscriber javaSubscriber = new SubscriberImpl();
        Subscriber allLanguagesSubscriber = new SubscriberImpl();
        Subscriber pythonSubscriber = new SubscriberImpl();

        PubSubService pubSubService = new PubSubService();

        //Declare Messages and Publish Messages to PubSubService
        Message javaMsg1 = new Message("Java", "Core Java Concepts");
        Message javaMsg2 = new Message("Java", "Spring MVC : Dependency Injection and AOP");
        Message javaMsg3 = new Message("Java", "JPA & Hibernate");

        javaPublisher.publish(javaMsg1, pubSubService);
        javaPublisher.publish(javaMsg2, pubSubService);
        javaPublisher.publish(javaMsg3, pubSubService);

        Message pythonMsg1 = new Message("Python", "Easy and Powerful programming language");
        Message pythonMsg2 = new Message("Python", "Advanced Python message");

        pythonPublisher.publish(pythonMsg1, pubSubService);
        pythonPublisher.publish(pythonMsg2, pubSubService);

        //Declare Subscribers
        javaSubscriber.subscribe("Java", pubSubService);		//Java subscriber only subscribes to Java topics
        pythonSubscriber.subscribe("Python", pubSubService);   //Python subscriber only subscribes to Python topics
        allLanguagesSubscriber.subscribe("Java", pubSubService);	//all subscriber, subscribes to both Java and Python
        allLanguagesSubscriber.subscribe("Python", pubSubService);

        pubSubService.broadcast();

        System.out.println("Java Subscriber");
        javaSubscriber.printMessage();
        System.out.println("Python Subscriber");
        pythonSubscriber.printMessage();
        System.out.println("All language Subscriber");
        allLanguagesSubscriber.printMessage();
    }
}
