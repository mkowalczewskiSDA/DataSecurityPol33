package com.example.DataSecurity.repository;

import com.example.DataSecurity.model.PortalUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<PortalUser, Integer> {

    Page<PortalUser> findAll(Pageable pageable);

    PortalUser findByLogin(String login);

    List<PortalUser> findByLoginStartsWith(String characters);


}
