package htw.gruppe.backend.record;

public record AuthResponse(
        String token,
        String matrikelnummer,
        String message
) {}
