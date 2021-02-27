package com.example.DataSecurity.service;

import com.example.DataSecurity.model.PortalUser;
import com.example.DataSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Page<PortalUser> findAllPagainated(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
