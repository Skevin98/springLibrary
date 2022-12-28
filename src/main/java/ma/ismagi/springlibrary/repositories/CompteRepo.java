package ma.ismagi.springlibrary.repositories;

import ma.ismagi.springlibrary.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepo extends JpaRepository<Compte,Long> {
}
