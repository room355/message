package pubsub.pojo;

public class Message {
    private String topic;
    private String context;

    public Message(String topic, String context) {
        this.topic = topic;
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Message{" +
                "context='" + context + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
