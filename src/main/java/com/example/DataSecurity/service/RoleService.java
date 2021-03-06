package com.example.DataSecurity.service;

import com.example.DataSecurity.model.Role;

public interface RoleService {

    void save(Role role);
    Role findById(int id);
    Role findByName(String name);
}
