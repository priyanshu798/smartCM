package com.scm.smartCM.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
    private boolean enabled = true;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;

    @Enumerated(value = EnumType.STRING)
    private Providers provider = Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();

    private List<String> roleList = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<SimpleGrantedAuthority> roles =  roleList.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
        return roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
