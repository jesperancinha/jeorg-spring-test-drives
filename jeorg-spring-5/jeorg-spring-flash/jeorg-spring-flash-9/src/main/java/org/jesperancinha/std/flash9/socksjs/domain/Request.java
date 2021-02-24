package org.jesperancinha.std.flash9.socksjs.domain;

import java.time.LocalDateTime;

public class Request {
    private String message;

    private LocalDateTime localDateTime;

    public String getMessage() {
        return message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
