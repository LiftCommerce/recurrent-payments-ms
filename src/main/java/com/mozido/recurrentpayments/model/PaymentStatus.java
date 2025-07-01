package com.mozido.recurrentpayments.model;

/**
 * Created by Rafael Richards on 06/25.
 */

public enum PaymentStatus {
    ACTIVE,
    EXPIRED,
    CANCELED,
    CONDITIONAL_PENDING,
    PENDING_SENDER_APPROVAL,
    MODIFIED,
    ENDED
}

