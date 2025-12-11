package com.renderreceiver.dto;

import com.renderreceiver.enumeration.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;
@Data
@Entity
public class Users {
    @Id
    @GeneratedValue(generator = "UUID")
    @JdbcTypeCode(Types.VARCHAR)
    @Column(name="userid")
    public UUID id;

    @Column(name="username")
    public String userName;

    @Column(name="password")
    public String password;

    @Column(name = "name")
    private String name;

    @Column(name="email")
    public String email;

    @Column(name = "role")
    private Role role = Role.ADMIN;
}
