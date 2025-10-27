package com.mozido.recurrentpayments.model;

public enum EventType {

    //This type is about the amount that the event can receive.
    FIXED, //Event can not go further than the goal amount
    OPEN    //Unlimited
}
