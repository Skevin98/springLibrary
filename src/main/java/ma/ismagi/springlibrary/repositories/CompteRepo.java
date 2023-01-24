package ma.ismagi.springlibrary.repositories;

import ma.ismagi.springlibrary.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompteRepo extends JpaRepository<Compte,Long> {
    List<Compte> findCompteByAdherent_id(Long id);
}
