package com.coudevi.web.controller;

import com.coudevi.application.dto.BaseResponseDto;
import com.coudevi.application.dto.LoginRequest;
import com.coudevi.application.dto.LoginResponse;
import com.coudevi.application.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService service;
    @PostMapping("/login")
    public ResponseEntity<BaseResponseDto<LoginResponse>> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(service.authenticate(loginRequest));
    }
}
