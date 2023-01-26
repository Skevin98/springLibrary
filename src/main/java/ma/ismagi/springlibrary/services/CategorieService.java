package ma.ismagi.springlibrary.services;

import ma.ismagi.springlibrary.models.Categorie;


import java.util.List;
import java.util.Optional;

public interface CategorieService {
    List<Categorie> getAll();
    Categorie saveOrUpdate(Categorie categorie);
    Optional<Categorie> getById(long id);
    void delete(long id);
    boolean existsById(long id);
}
