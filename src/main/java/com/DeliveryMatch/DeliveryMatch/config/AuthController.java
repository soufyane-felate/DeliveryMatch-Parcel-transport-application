package com.DeliveryMatch.DeliveryMatch.config;

import com.DeliveryMatch.DeliveryMatch.Dto.*;
import com.DeliveryMatch.DeliveryMatch.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register/conducteur")
    public ResponseEntity<AuthResponse> registerConducteur(@RequestBody ConducteurRegisterDto request) {
        return ResponseEntity.ok(authService.registerConducteur(request));
    }

    @PostMapping("/register/expediteur")
    public ResponseEntity<AuthResponse> registerExpediteur(@RequestBody ExpediteurRegisterDto request) {
        return ResponseEntity.ok(authService.registerExpediteur(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}