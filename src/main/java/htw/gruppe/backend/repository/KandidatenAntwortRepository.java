package htw.gruppe.backend.repository;

import htw.gruppe.backend.entity.KandidatenAntwort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface KandidatenAntwortRepository extends JpaRepository<KandidatenAntwort, Long> {

    // Kandidat anhand Id suchen
    List<KandidatenAntwort> findByKandidatId(Long kandidatId);
}
