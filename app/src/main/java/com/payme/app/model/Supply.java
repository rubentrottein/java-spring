package com.payme.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Supply extends Operation{


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long Id;

}
