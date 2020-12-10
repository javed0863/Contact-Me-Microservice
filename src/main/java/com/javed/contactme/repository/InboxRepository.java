package com.javed.contactme.repository;

import com.javed.contactme.model.Inbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InboxRepository extends JpaRepository<Inbox, Long> {
}
