package ma.ismagi.springlibrary.services;

import ma.ismagi.springlibrary.models.Emprunt;
import ma.ismagi.springlibrary.models.Livre;

import java.util.List;

public interface LivreService {

    List<Livre> getAll();

    Livre saveOrUpdate(Livre livre);
    List<Livre> getByCategorieId(long id);
    boolean existsByIsbn(String isbn);
}
