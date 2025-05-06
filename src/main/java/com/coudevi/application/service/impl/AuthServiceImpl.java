package com.coudevi.application.service.impl;

import com.coudevi.application.dto.BaseResponseDto;
import com.coudevi.application.dto.LoginRequest;
import com.coudevi.application.dto.LoginResponse;
import com.coudevi.application.service.IAuthService;
import com.coudevi.security.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    @Override
    public BaseResponseDto<LoginResponse> authenticate(LoginRequest loginRequest) {
        BaseResponseDto<LoginResponse> response = new BaseResponseDto<>();
        response.setSuccess(true);
        response.setMessage("Credenciales correctas.");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            UserDetails user = userDetailsService.loadUserByUsername(loginRequest.getUsername());

            String token = jwtUtil.generateToken(user);
            long expiration = jwtUtil.extractExpiration(token).getTime();
            var res = LoginResponse.builder()
                    .token(token)
                    .username(user.getUsername())
                    .roles(user.getAuthorities().stream()
                            .map(r -> r.getAuthority())
                            .toList())
                    .expirateAt(expiration)
                    .build();

            response.setData(res);
        } catch (BadCredentialsException e) {
            response.setSuccess(false);
            response.setMessage("Credenciales incorrectas");
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Error al autenticar el usuario");
        }
        return response;
    }
}


