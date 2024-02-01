package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Innovation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int innovationId;
    String innovationName;

    public int getInnovationId() {
        return innovationId;
    }

    public void setInnovationId(int innovationId) {
        this.innovationId = innovationId;
    }

    public String getInnovationName() {
        return innovationName;
    }

    public void setInnovationName(String innovationName) {
        this.innovationName = innovationName;
    }
}
