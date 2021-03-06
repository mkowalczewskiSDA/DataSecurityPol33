package com.example.DataSecurity.service;

import com.example.DataSecurity.model.PortalUser;
import com.example.DataSecurity.model.Role;
import com.example.DataSecurity.repository.RoleRepository;
import com.example.DataSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Page<PortalUser> findAllPagainated(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void save(PortalUser portalUser) {
        portalUser.setPassword(passwordEncoder.encode(portalUser.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("USER"));
        portalUser.setRoles(roles);
        userRepository.save(portalUser);
    }

    @Override
    public PortalUser findByLogin(String login) {
        return findByLogin(login);
    }


}
