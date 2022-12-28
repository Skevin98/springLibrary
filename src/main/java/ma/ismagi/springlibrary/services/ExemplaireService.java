package ma.ismagi.springlibrary.services;

import ma.ismagi.springlibrary.models.Exemplaire;

import java.util.List;
import java.util.Optional;

public interface ExemplaireService {
    List<Exemplaire> getByIsbn(String isbn);
    Optional<Exemplaire> getById(long id);
    Exemplaire saveOrUpdate(Exemplaire exemplaire);
    void delete(long id);
    Boolean existsById(long id);

}
