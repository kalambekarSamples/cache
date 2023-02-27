package com.bac.cache.redis.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AdapterDet implements Serializable {

    @Id
    String adapterId;

    String adapterName;

    String description;

    String status;
}
