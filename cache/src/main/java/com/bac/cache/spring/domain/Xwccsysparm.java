package com.bac.cache.spring.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "XWCCSYSPARM")
@AllArgsConstructor
@NoArgsConstructor
public class Xwccsysparm implements Serializable {

    XwccsysparmId id;

    String dataValue;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "grouprefid", column = @Column(name="GROUPREFID", nullable = false)),
            @AttributeOverride(name = "category", column = @Column(name="CATEGORY", nullable = false)),
            @AttributeOverride(name = "keyId", column = @Column(name="KEY_ID", nullable = false)),
            @AttributeOverride(name = "seqNum", column = @Column(name="SEQ_NUM", nullable = false))
    })
    public XwccsysparmId getId() {
        return this.id;
    }

    public void setId(XwccsysparmId id) {
        this.id = id;
    }
}