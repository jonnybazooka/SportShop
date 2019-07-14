package org.sda.models.dto;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String passHash;
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Basket basket;

    public Client() {
    }

    public Client(String name, String email, String passHash) {
        this.name = name;
        this.email = email;
        this.passHash = passHash;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }
}
