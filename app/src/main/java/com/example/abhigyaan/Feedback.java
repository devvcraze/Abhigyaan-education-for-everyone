package com.example.abhigyaan;

public class Feedback {
    private String name;
    private String feedback;
    private long timestamp;



    public Feedback(String name, String feedback, long timestamp) {
        this.name = name;
        this.feedback = feedback;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
