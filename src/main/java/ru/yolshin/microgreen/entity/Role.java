package ru.yolshin.microgreen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "microgreen_role")
@Table(name = "microgreen_role")
public class Role extends SuperReference implements GrantedAuthority {
    @Column(unique = true, nullable = false)
    private String authority;

    public Role() {}

    public Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Role role) {
            return getId() == role.getId() && Objects.equals(getAuthority(), role.getAuthority());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthority());
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                '}';
    }
}
