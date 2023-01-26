package ma.ismagi.springlibrary.services;

import ma.ismagi.springlibrary.models.Compte;

import java.util.List;
import java.util.Optional;

public interface CompteService {

    List<Compte> getAll();

    Optional<Compte> getById(long id);

    List<Compte> getByAdherentId(long id);

    Compte saveOrUpdate(Compte compte);

    void delete(long id);

    Boolean existsById(long id);
}
