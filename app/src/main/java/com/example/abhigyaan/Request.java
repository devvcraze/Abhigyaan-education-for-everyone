package com.example.abhigyaan;

public class Request {

    private String id;
    private String name;
    private String whatsAppNumber;
    private String dateTime;
    private String reason;
    private boolean accepted;
    private String acceptedBy;

    public Request() {
        // Default constructor required for calls to DataSnapshot.getValue(Request.class)
    }

    public Request(String id, String name, String whatsAppNumber, String dateTime, String reason, boolean accepted, String acceptedBy) {
        this.id = id;
        this.name = name;
        this.whatsAppNumber = whatsAppNumber;
        this.dateTime = dateTime;
        this.reason = reason;
        this.accepted = accepted;
        this.acceptedBy = acceptedBy;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWhatsAppNumber() {
        return whatsAppNumber;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getReason() {
        return reason;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public String getAcceptedBy() {
        return acceptedBy;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public void setAcceptedBy(String acceptedBy) {
        this.acceptedBy = acceptedBy;
    }
}
