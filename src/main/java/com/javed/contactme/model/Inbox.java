package com.javed.contactme.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Inbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="subject")
    private String subject;

    @Column(name="message")
    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name="creation_date")
    private Date creationDate;
}
