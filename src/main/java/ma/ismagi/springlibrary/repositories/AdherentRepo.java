package ma.ismagi.springlibrary.repositories;

import ma.ismagi.springlibrary.models.Adherent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdherentRepo extends JpaRepository<Adherent, Long> {
}
