package com.example.DataSecurity.repository;

import com.example.DataSecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findById(int id);
    Role findByName(String name);
    List<Role> findByNameContains(String name);

}

