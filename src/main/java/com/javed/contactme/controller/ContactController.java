package com.javed.contactme.controller;

import com.javed.contactme.model.ContactMeResponseDto;
import com.javed.contactme.model.Inbox;
import com.javed.contactme.service.InboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/portfolio")
public class ContactController {

    public static final String UNKNOWN = "UNKNOWN";

    @Autowired
    private InboxService inboxService;

    @PostMapping("/contactMe")
    public ResponseEntity<ContactMeResponseDto> contactMe(@RequestBody MultiValueMap<String, String> formData){

        final String firstName = Optional.ofNullable(formData.get("firstName"))
                .map(val->val.get(0))
                .orElse(UNKNOWN);
        final String lastName = Optional.ofNullable(formData.get("lastName"))
                .map(val->val.get(0))
                .orElse(UNKNOWN);
        final String email = Optional.ofNullable(formData.get("email"))
                .map(val->val.get(0))
                .orElse(UNKNOWN);
        final String subject = Optional.ofNullable(formData.get("subject"))
                .map(val->val.get(0))
                .orElse(UNKNOWN);
        final String msg = Optional.ofNullable(formData.get("msg"))
                .map(val->val.get(0))
                .orElse(UNKNOWN);

        if(email.equals(UNKNOWN) ||
                subject.equals(UNKNOWN) ||
                msg.equals(UNKNOWN)){
            throw new RuntimeException("email, subject or message not found");
        }

        Inbox inboxRecord = new Inbox();
        inboxRecord.setFirstName(firstName);
        inboxRecord.setLastName(lastName);
        inboxRecord.setEmail(email);
        inboxRecord.setSubject(subject);
        inboxRecord.setMessage(msg);
        inboxService.save(inboxRecord);

        return new ResponseEntity<>(new ContactMeResponseDto("success"), HttpStatus.OK);
    }
}
