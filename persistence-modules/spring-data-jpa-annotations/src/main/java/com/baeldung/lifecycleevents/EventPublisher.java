package com.baeldung.lifecycleevents;

import org.springframework.stereotype.Component;

@Component
public class EventPublisher {
    public void publishEvent(String s) {
        System.out.println("Publishing " + s);
    }
}
