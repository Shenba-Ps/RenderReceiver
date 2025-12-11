package com.renderreceiver.dto;

import com.renderreceiver.enumeration.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;
@Data
@Entity
public class Users {
    @Id
    public UUID id;
    public String userName;
    public String password;
    public String email;
    public String name;
    private Role role = Role.ADMIN;
}
