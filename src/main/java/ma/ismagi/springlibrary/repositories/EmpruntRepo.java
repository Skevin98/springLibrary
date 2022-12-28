package ma.ismagi.springlibrary.repositories;

import ma.ismagi.springlibrary.models.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpruntRepo extends JpaRepository<Emprunt, String> {
    List<Emprunt> findEmpruntsByAdherent_Id(Long id);
    List<Emprunt> findEmpruntsByExemplaire_Id(Long id);

}
