package com.renderreceiver.dto;

import com.renderreceiver.enumeration.Role;
import lombok.Data;

import java.util.UUID;
@Data
public class Users {
    public UUID id;
    public String userName;
    public String password;
    public String email;
    public String name;
    private Role role = Role.ADMIN;
}
