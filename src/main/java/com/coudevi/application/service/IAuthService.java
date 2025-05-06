package com.coudevi.application.service;

import com.coudevi.application.dto.BaseResponseDto;
import com.coudevi.application.dto.LoginRequest;
import com.coudevi.application.dto.LoginResponse;

public interface IAuthService {
    BaseResponseDto<LoginResponse> authenticate(LoginRequest loginRequest);
}
