package com.javed.contactme.service;

import com.javed.contactme.model.Inbox;
import com.javed.contactme.repository.InboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InboxService {

    @Autowired
    private InboxRepository inboxRepository;

    public void save(Inbox inboxRecord) {
        inboxRepository.save(inboxRecord);
    }
}
