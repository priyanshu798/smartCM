package com.scm.smartCM.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Contact {
    @Id
    private String userId;

    private String name;

    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    private boolean favourite = false;
    private String websiteLink;
    @Column(length = 10000)
    private String description;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SocialLink> links = new ArrayList<>();

}
