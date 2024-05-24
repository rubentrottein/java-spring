package com.payme.app.model;

import jakarta.persistence.*;

import java.time.LocalDate;

public abstract class Operation {

    LocalDate date;
    Float amount;
    String label;



    @ManyToOne
    @JoinColumn(name="receiver_id")
    User receiver;
}
