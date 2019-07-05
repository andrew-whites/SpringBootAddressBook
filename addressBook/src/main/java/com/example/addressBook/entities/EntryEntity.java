package com.example.addressBook.entities;

import com.querydsl.core.annotations.QueryProjection;

import javax.persistence.*;

@Entity
@Table(name = "entrys")
public class EntryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String county;
    private String country;
    private String postalCode;
    private String phoneNumber;
    private String emailAddress;

    public EntryEntity(){}

    @QueryProjection
    public EntryEntity(String firstName, String lastName, String addressLine1, String addressLine2, String addressLine3,
                       String city, String county, String country, String postalCode, String phoneNumber,
                       String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.city = city;
        this.county = county;
        this.country = country;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public EntryEntity(EntryEntity newEntry){
        this(newEntry.getFirstName(), newEntry.getLastName(), newEntry.getAddressLine1(), newEntry.getAddressLine2(),
                newEntry.getAddressLine3(), newEntry.getCity(), newEntry.getCounty(), newEntry.getCountry(),
                newEntry.getPostalCode(), newEntry.getPhoneNumber(), newEntry.getEmailAddress());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public EntryEntity updateEntry(EntryEntity newEntry){
        this.firstName = (newEntry.getFirstName()!=null) ? newEntry.getFirstName() : this.firstName;
        this.lastName = (newEntry.getLastName()!=null) ? newEntry.getLastName() : this.lastName;
        this.addressLine1 = (newEntry.getAddressLine1()!=null) ? newEntry.getAddressLine1() : this.addressLine1;
        this.addressLine2 = (newEntry.getAddressLine2()!=null) ? newEntry.getAddressLine2() : this.addressLine2;
        this.addressLine3 = (newEntry.getAddressLine3()!=null) ? newEntry.getAddressLine3() : this.addressLine3;
        this.city = (newEntry.getCity()!=null) ? newEntry.getCity() : this.city;
        this.county = (newEntry.getCounty()!=null) ? newEntry.getCounty() : this.county;
        this.country = (newEntry.getCountry()!=null) ? newEntry.getCountry() : this.country;
        this.postalCode = (newEntry.getPostalCode()!=null) ? newEntry.getPostalCode() : this.postalCode;
        this.phoneNumber = (newEntry.getPhoneNumber()!=null) ? newEntry.getPhoneNumber() : this.phoneNumber;
        this.emailAddress = (newEntry.getEmailAddress()!=null) ? newEntry.getEmailAddress() : this.emailAddress;
        return this;
    }
}
