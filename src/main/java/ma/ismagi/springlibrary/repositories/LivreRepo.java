package ma.ismagi.springlibrary.repositories;

import ma.ismagi.springlibrary.models.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreRepo extends JpaRepository<Livre,Long> {
    boolean existsByIsbn(String isbn);

    List<Livre> findLivresByCategorie_Id(long id);
}
