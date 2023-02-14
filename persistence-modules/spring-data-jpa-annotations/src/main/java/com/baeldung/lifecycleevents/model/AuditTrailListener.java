package com.baeldung.lifecycleevents.model;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import com.baeldung.lifecycleevents.EventPublisher;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuditTrailListener {
    private static Log log = LogFactory.getLog(AuditTrailListener.class);

    @Autowired
    EventPublisher eventPublisher;

    @PreRemove
    private void beforeRemove(User user) {
        eventPublisher.publishEvent(user.getFirstName());
        if (user.getId() == 0) {
            log.info("[USER AUDIT] About to add a user");
        } else {
            log.info("[USER AUDIT] About to update/delete user: " + user.getId());
        }
    }
}
