package com.example.ecommerce.services.abstracts;

import com.example.ecommerce.dtos.users.AuthenticationResponse;
import com.example.ecommerce.dtos.users.CreateUserRequest;
import com.example.ecommerce.dtos.users.LoginRequest;

public interface AuthService {
    AuthenticationResponse register(CreateUserRequest request);
    AuthenticationResponse authenticate(LoginRequest request);
}
