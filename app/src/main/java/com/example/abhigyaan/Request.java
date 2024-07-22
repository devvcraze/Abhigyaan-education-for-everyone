package com.example.abhigyaan;

public class Request {
    private String id;
    private String name;
    private String whatsappNumber;
    private String dateTime;
    private String reason;
    private boolean accepted;
    private String acceptedBy;

    // Default constructor required for calls to DataSnapshot.getValue(Request.class)
    public Request() {}

    public Request(String id, String name, String whatsappNumber, String dateTime, String reason, boolean accepted, String acceptedBy) {
        this.id = id;
        this.name = name;
        this.whatsappNumber = whatsappNumber;
        this.dateTime = dateTime;
        this.reason = reason;
        this.accepted = accepted;
        this.acceptedBy = acceptedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWhatsappNumber() {
        return whatsappNumber;
    }

    public void setWhatsappNumber(String whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public String getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(String acceptedBy) {
        this.acceptedBy = acceptedBy;
    }
}
