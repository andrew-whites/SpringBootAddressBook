package com.example.addressBook;

import com.example.addressBook.entities.EntryEntity;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EntryEntityTests {

    @Test
    public void testEntryUpdate(){
        EntryEntity testData = createEntryEntity();
        EntryEntity updateData = new EntryEntity();
        updateData.setFirstName("Updated");
        updateData.setLastName("Data");
        updateData.setAddressLine1("newAddressLine1");
        updateData.setAddressLine2("newAddressLine2");
        updateData.setAddressLine3("newAddressLine3");
        updateData.setCity("newCity");
        updateData.setCounty("newCounty");
        updateData.setCountry("newCountry");
        updateData.setPostalCode("newPostalCode");
        updateData.setPhoneNumber("newPhoneNumber");
        updateData.setEmailAddress("newEmailAddress");

        testData.updateEntry(updateData);

        assertEquals(testData.getFirstName(), (updateData.getFirstName()));
        assertEquals(testData.getLastName(), (updateData.getLastName()));
        assertEquals(testData.getAddressLine1(), (updateData.getAddressLine1()));
        assertEquals(testData.getAddressLine2(), (updateData.getAddressLine2()));
        assertEquals(testData.getAddressLine3(), (updateData.getAddressLine3()));
        assertEquals(testData.getCity(), (updateData.getCity()));
        assertEquals(testData.getCounty(), (updateData.getCounty()));
        assertEquals(testData.getCountry(), (updateData.getCountry()));
        assertEquals(testData.getPostalCode(), (updateData.getPostalCode()));
        assertEquals(testData.getPhoneNumber(), (updateData.getPhoneNumber()));
        assertEquals(testData.getEmailAddress(), (updateData.getEmailAddress()));
    }

    @Test
    public void testEntryUpdateWithNull(){
        EntryEntity testData = createEntryEntity();
        EntryEntity updateData = new EntryEntity();
        updateData.setFirstName("Updated");

        testData.updateEntry(updateData);

        assertNull(updateData.getLastName());
        assertEquals(testData.getFirstName(), updateData.getFirstName());
    }

    private EntryEntity createEntryEntity(){
        EntryEntity testData = new EntryEntity("Test", "Name", "addressLine1", "addressLine2",
                "addressLine3", "City", "County", "Country", "PostalCode",
                "PhoneNumber", "EmailAddress");
        testData.setId(1234);
        return testData;
    }
}
