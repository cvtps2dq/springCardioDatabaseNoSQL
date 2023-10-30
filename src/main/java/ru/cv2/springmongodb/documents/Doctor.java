package ru.cv2.springmongodb.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doctors")
@CompoundIndex(def = "{'name': 1}", unique = true, background = false, sparse = false)
public class Doctor {
    @Id
    private String id;
    private String name;
    private String surname;
    private Integer age;
    private String patient;
    private String blockId;

    public Doctor() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    private Doctor(String id, String name, String surname, Integer age, String patient, String blockId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.patient = patient;
        this.blockId = blockId;
    }
}
