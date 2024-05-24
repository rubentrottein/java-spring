package com.payme.app.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    private float balance;
    private String iban;
    private String email;
    private String password;

    @ManyToMany
    private ArrayList<User> contactList;

    @OneToMany(mappedBy="sender")
    private ArrayList<Transaction> transactionList;

    public User(String name, float balance, String iban, String email, String password, ArrayList<User> contactsList, ArrayList<Transaction> transactionList) {
    //TODO effacer le contrôleur une fois les User persistants
    }
}
