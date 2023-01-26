package ma.ismagi.springlibrary.services;

import ma.ismagi.springlibrary.models.Emprunt;
import ma.ismagi.springlibrary.models.Exemplaire;

import java.util.List;
import java.util.Optional;

public interface EmpruntService {
    List<Emprunt> getAll();
    Optional<Emprunt> getById(long id);
    List<Emprunt> getByAdherentId(long id);
    List<Emprunt> getByExemplaireId(long id);

    List<Emprunt> getByLivreIsbn(String isbn);
    Emprunt saveOrUpdate(Emprunt emprunt);
    void delete(long id);
    Boolean existsById(long id);
}
