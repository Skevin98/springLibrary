package ma.ismagi.springlibrary.repositories;

import ma.ismagi.springlibrary.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepo extends JpaRepository<Categorie, Long> {
}
