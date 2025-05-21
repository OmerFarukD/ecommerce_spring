package com.example.ecommerce.services.concretes;

import com.example.ecommerce.dtos.users.AuthenticationResponse;
import com.example.ecommerce.dtos.users.CreateUserRequest;
import com.example.ecommerce.dtos.users.LoginRequest;
import com.example.ecommerce.entites.Role;
import com.example.ecommerce.entites.User;
import com.example.ecommerce.repository.RoleRepository;
import com.example.ecommerce.security.repository.UserRepository;
import com.example.ecommerce.security.services.JwtService;
import com.example.ecommerce.services.abstracts.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class AuthManager implements AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthManager(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticationResponse register(CreateUserRequest request) {
        if (userRepository.existsByUsername(request.username()))
            throw new IllegalStateException("Username already taken");
        if (userRepository.existsByEmail(request.email()))
            throw new IllegalStateException("Email already in use");

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new IllegalStateException("Default role not found"));

        User user = User.builder()
                .username(request.username())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .roles(Set.of(userRole))
                .build();

        userRepository.save(user);
        String jwt = jwtService.generateToken(user);
        return new AuthenticationResponse(jwt);
    }

    @Override
    public AuthenticationResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        User user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        String jwt = jwtService.generateToken(user);
        return new AuthenticationResponse(jwt);
    }
}
