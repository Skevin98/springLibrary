package ma.ismagi.springlibrary.repositories;

import ma.ismagi.springlibrary.models.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepo extends JpaRepository<Livre,Long> {
}
