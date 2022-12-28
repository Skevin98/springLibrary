package ma.ismagi.springlibrary.repositories;

import ma.ismagi.springlibrary.models.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExemplaireRepo extends JpaRepository<Exemplaire, Long> {

    List<Exemplaire> findExemplairesByLivre_Isbn(String isbn);
}
