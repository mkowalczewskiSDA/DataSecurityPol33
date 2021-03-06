package com.example.DataSecurity.service;

import com.example.DataSecurity.model.PortalUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<PortalUser> findAllPagainated(Pageable pageable);
    void save(PortalUser portalUser);
    PortalUser findByLogin(String login);

}
