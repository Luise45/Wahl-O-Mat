package htw.gruppe.backend.repository;
import htw.gruppe.backend.entity.Aussage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AussagenRepository extends JpaRepository<Aussage, Long>
{
//Aussagen anhand von Status suchen
List<Aussage> findByAktivTrue();
}