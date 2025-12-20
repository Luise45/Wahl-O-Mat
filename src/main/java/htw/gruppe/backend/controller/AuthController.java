package htw.gruppe.backend.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import htw.gruppe.backend.service.AuthService;
import htw.gruppe.backend.record.AuthResponse;
import htw.gruppe.backend.record.LoginRequest;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name="Auth", description ="Login Api") // fur swagger
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
//  login des Kandidaten
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        try {
            AuthResponse response = authService.login(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest()
                    .body(new AuthResponse(null, null, "Fehlermeldung"));
        }
    }



}
