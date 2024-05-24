package com.payme.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Transaction extends Operation {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long Id;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private User sender;

}