package com.payme.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Transaction {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long Id;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name="receiver_id")
    private User receiver;

    private Date date;

    private float amount;

    private String label;
}