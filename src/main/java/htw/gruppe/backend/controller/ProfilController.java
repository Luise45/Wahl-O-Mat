package htw.gruppe.backend.controller;

import htw.gruppe.backend.record.ProfilRequest;
import htw.gruppe.backend.record.ProfilResponse;
import htw.gruppe.backend.service.ProfilService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST-Controller für die Verwaltung des Kandidatenprofils.
 * Unterstützt das Abrufen und Aktualisieren von Profilen.
 */
@RestController
@RequestMapping("/api/profil")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Profile", description = "Profile Kandidaten Api")// fur swagger
public class ProfilController {

    private final ProfilService profilService;
    private final Logger log = LoggerFactory.getLogger(ProfilController.class);

    /**
     * Konstrktor für ProfilController
     *
     * @param profilService Service zur Verwaltung von Profilen
     */
    public ProfilController(ProfilService profilService) {
        this.profilService = profilService;
    }

    /**
     * Holt ein Profil anhand der Matrikelnummer
     *
     * @param matrikelnummer Matrikelnummer des Kandidaten
     * @return Profilresponse mit allen Profildaten oder 404, falls Kandidat nicht gefunden wurde
     */
    @GetMapping("/{matrikelnummer}")
    public ResponseEntity<ProfilResponse> getProfil(@PathVariable String matrikelnummer) {
        log.info("GET Profil {}", matrikelnummer);
        return profilService.getProfilByMatrikelnummer(matrikelnummer)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Legt ein neues Profil für einen Kandidaten an
     *
     * @param request ProfilRequest mit allen Profilinformationen
     * @return ResponseEntity mit dem erstellten Profil
     */
    @PostMapping
    public ResponseEntity<ProfilResponse> createProfil(@RequestBody ProfilRequest request){
        log.info("POST neues Profil für {}", request.matrikelnummer());

        return profilService.createProfil(request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
    /**
     * Aktualisiert das Profil eines Kandidaten
     *
     * @param matrikelnummer Matrikelnummer des Kandidaten
     * @param request        Profilrequest mit neuen Daten
     * @return Aktualisiertes Profil oder 404, falls Kandidat nicht gefunden wurde
     */
    @PutMapping("/{matrikelnummer}")
    public ResponseEntity<ProfilResponse> updateProfil(
            @PathVariable String matrikelnummer,
            @RequestBody ProfilRequest request
    ) {
        log.info("PUT Update Profil {}", matrikelnummer);

        return profilService.updateProfil(matrikelnummer, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
