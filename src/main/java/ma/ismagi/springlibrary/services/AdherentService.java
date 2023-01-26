package ma.ismagi.springlibrary.services;

import ma.ismagi.springlibrary.models.Adherent;

import java.util.List;
import java.util.Optional;

public interface AdherentService {

    List<Adherent> getAll();

    Optional<Adherent> getById(long id);

    List<Adherent> getByCompteId(long id);



    Adherent saveOrUpdate(Adherent adherent);

    void delete(long id);

    Boolean existsById(long id);
}
