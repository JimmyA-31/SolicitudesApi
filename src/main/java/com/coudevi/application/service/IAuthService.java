package com.coudevi.application.service;

import com.coudevi.application.dto.LoginRequest;
import com.coudevi.application.dto.LoginResponse;

public interface IAuthService {
    LoginResponse authenticate(LoginRequest loginRequest);
}
