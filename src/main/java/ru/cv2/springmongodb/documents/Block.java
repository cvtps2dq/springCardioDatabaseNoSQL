package ru.cv2.springmongodb.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "blocks")
public class Block {
    @Id
    private String id;
    private String phoneNumber;
    private String zip;
    private String address;

    public Block() {
    }

    private Block(String id, String phoneNumber, String zip, String address) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.zip = zip;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
