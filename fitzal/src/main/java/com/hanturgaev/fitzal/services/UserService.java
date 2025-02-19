package com.hanturgaev.fitzal.services;

import com.hanturgaev.fitzal.models.User;
import com.hanturgaev.fitzal.models.UserRole;
import com.hanturgaev.fitzal.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        user.setRole(UserRole.CLIENT_ROLE);
        user.setPassword("{noop}"+user.getPassword());
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
