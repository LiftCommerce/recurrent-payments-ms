package com.mozido.recurrentpayments.model;

/**
 * Created by Orlando on 10/15/19.
 */
public class Summary {

    private Integer pendingInvitation; //events
    private Integer pendingIncomingMoneyRequests; //
    private Integer reachedEvents; //
    private Integer pendingMessages;

    public Summary() {
        this.setPendingIncomingMoneyRequests(0);
        this.setReachedEvents(0);
        this.setPendingInvitation(0);
        this.setPendingMessages(0);
    }

    public Integer getPendingInvitation() {
        return pendingInvitation;
    }

    public void setPendingInvitation(Integer pendingInvitation) {
        this.pendingInvitation = pendingInvitation;
    }

    public Integer getPendingIncomingMoneyRequests() {
        return pendingIncomingMoneyRequests;
    }

    public void setPendingIncomingMoneyRequests(Integer pendingIncomingMoneyRequests) {
        this.pendingIncomingMoneyRequests = pendingIncomingMoneyRequests;
    }

    public Integer getReachedEvents() {
        return reachedEvents;
    }

    public void setReachedEvents(Integer reachedEvents) {
        this.reachedEvents = reachedEvents;
    }

    public Integer getPendingMessages() {
        return pendingMessages;
    }

    public void setPendingMessages(Integer pendingMessages) {
        this.pendingMessages = pendingMessages;
    }
}
