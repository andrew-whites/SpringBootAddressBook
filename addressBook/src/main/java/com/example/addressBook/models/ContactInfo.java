package com.example.addressBook.models;

import com.example.addressBook.entities.EntryEntity;

public class ContactInfo {

    private String phoneNumber;
    private String emailAddress;

    public ContactInfo(String phoneNumber, String emailAddress){
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public ContactInfo(EntryEntity entry) {
        this(entry.getPhoneNumber(), entry.getEmailAddress());
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
