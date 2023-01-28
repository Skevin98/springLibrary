package ma.ismagi.springlibrary.services;

import ma.ismagi.springlibrary.models.Livre;

import java.util.List;
import java.util.Optional;

public interface LivreService {

    List<Livre> getAll();

    Optional<Livre> getByIsbn(String isbn);

    Livre saveOrUpdate(Livre livre);
    List<Livre> getByCategorie(long id);
    boolean existsByIsbn(String isbn);
}
