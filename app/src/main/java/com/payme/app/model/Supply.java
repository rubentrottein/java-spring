package com.payme.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Supply{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private User user;

    private Date date;

    private float amount;

    private String label;
}
