package com.bac.cache.redis.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;



@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Getter
@Setter
public class XwccsysparmId implements Serializable {

    String grouprefid;
    String category;
    String keyId;
    String seqNum;
}