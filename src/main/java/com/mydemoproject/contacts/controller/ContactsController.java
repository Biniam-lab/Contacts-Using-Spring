package com.mydemoproject.contacts.controller;

import com.mydemoproject.contacts.error.ContactNotFoundException;
import com.mydemoproject.contacts.model.ContactsModel;
import com.mydemoproject.contacts.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    @GetMapping("/")
    public String welcome(){
        return "Welcome to sample contact list application";
    }

    @PostMapping("/contacts")
    public ContactsModel saveContacts(@RequestBody ContactsModel contactsModel){
        return contactsService.saveContacts(contactsModel);
    }

    @GetMapping("/contacts")
    public List<ContactsModel> findContacts(){
        return contactsService.findContacts();
    }

    @GetMapping("/contacts/{id}")
    public ContactsModel findContactById(@PathVariable("id") UUID contactId){
        return contactsService.findContactById(contactId);
    }

    @PutMapping("/contacts/{id}")
    public ContactsModel updateContact(@PathVariable("id") UUID contactId, @RequestBody ContactsModel contactsModel){
        return contactsService.updateContact(contactId, contactsModel);
    }


}
