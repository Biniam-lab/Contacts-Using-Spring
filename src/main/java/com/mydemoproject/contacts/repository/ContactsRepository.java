package com.mydemoproject.contacts.repository;

import com.mydemoproject.contacts.model.ContactsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContactsRepository extends JpaRepository<ContactsModel, UUID> {

}
