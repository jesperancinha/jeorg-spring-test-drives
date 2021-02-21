package org.jesperancinha.std.flash7.session.handlers;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MixErrorMessage {
    private String message;

    public MixErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
