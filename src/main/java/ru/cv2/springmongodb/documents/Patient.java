package ru.cv2.springmongodb.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.cv2.springmongodb.abstracts.ExtendedBaseEntity;

@Document(collection = "patients")
@CompoundIndex(def = "{'name': 1}", unique = true, background = false, sparse = false)
public class Patient extends ExtendedBaseEntity {
    private Integer age;
    private String diagnosis;
    private String condition;

    public Patient() {
    }

    private Patient(String id, String name, String surname, Integer age, String diagnosis, String condition, String blockId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.diagnosis = diagnosis;
        this.condition = condition;
        this.blockId = blockId;
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

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }
}
