package com.scm.smartCM.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    private String userId;
    @Column(name = "user_name")
    private String name;
    @Column(unique = true, nullable = false)
    private String email;

    @Getter(value = AccessLevel.NONE)
    private String password;
    @Column(length = 10000)
    private String about;
    private String profilePic;
    private String phoneNumber;

    @Getter(value = AccessLevel.NONE)
    private boolean enabled = false;

    private boolean emailVerified = false;
    private boolean phoneVerified = false;

    @Enumerated(value = EnumType.STRING)
    private Providers provider = Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    List<Contact> contacts = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roleList = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //converted list of roles to collection of SimpleGrantedAuthority
        Collection<SimpleGrantedAuthority> roles = roleList.stream().map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
        return roles;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
      return true;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
