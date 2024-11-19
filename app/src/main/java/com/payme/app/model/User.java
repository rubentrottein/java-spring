package com.payme.app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
    private float balance;
    private String iban;
    private String email;
    private String password;

    @ManyToMany
    private List<User> contactList;

    @OneToMany(mappedBy="sender")
    private List<Transaction> transactionList;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Supply> supplyList;

    @Override
    public String getUsername() {
        return name; // Use 'name' as username
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER")); // Add a default role
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
            "password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", iban='" + iban + '\'' +
            ", balance=" + balance +
            ", name='" + name + '\'' +
            ", id=" + id +
            '}';
    }

}
