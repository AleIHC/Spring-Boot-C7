package org.generation.cyberpunk.services;

import jakarta.transaction.Transactional;
import org.generation.cyberpunk.DTO.UserDTO;
import org.generation.cyberpunk.models.User;
import org.generation.cyberpunk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDTO saveUser(UserDTO newUser) {
        User userToSave = new User();
        userToSave.setEmail(newUser.getEmail());
        userToSave.setPassword(newUser.getPassword());

        userRepository.save(userToSave);
        return newUser;

    }
}
