package ru.yolshin.microgreen.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity(name = "microgreen_role")
@Table(name = "microgreen_role")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String authority;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
