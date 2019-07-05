package com.example.addressBook.models;

import com.example.addressBook.entities.EntryEntity;

public class Entry {

    private Integer id;
    private String firstName;
    private String lastName;
    private Address address;
    private ContactInfo contactInfo;

    public Entry(Integer id, String firstName, String lastName, Address address, ContactInfo contactInfo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactInfo = contactInfo;
    }

    public Entry(Integer id, String firstName, String lastName, String addressLine1, String addressLine2, String addressLine3,
                 String city, String county, String country, String postalCode, String phoneNumber, String emailAddress){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = new Address(addressLine1, addressLine2, addressLine3, city, county, country, postalCode);
        this.contactInfo = new ContactInfo(phoneNumber, emailAddress);
    }

    public Entry(EntryEntity entryEntity) {
        this(entryEntity.getId(), entryEntity.getFirstName(), entryEntity.getLastName(),
                entryEntity.getAddressLine1(), entryEntity.getAddressLine2(), entryEntity.getAddressLine3(),
                entryEntity.getCity(), entryEntity.getCounty(), entryEntity.getCountry(),
                entryEntity.getPostalCode(), entryEntity.getPhoneNumber(), entryEntity.getEmailAddress());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}
