package ma.ismagi.springlibrary.repositories;

import ma.ismagi.springlibrary.models.Adherent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdherentRepo extends JpaRepository<Adherent, Long> {
    List<Adherent> findAdherentByCompte_id(Long id);




}
