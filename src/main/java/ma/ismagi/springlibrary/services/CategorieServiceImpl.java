package ma.ismagi.springlibrary.services;

import ma.ismagi.springlibrary.models.Categorie;
import ma.ismagi.springlibrary.repositories.CategorieRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {
 private CategorieRepo categorieRepo;
 public CategorieServiceImpl(CategorieRepo _categorieRepo){categorieRepo=_categorieRepo;}
    @Override
    public List<Categorie> getAll() {
        return categorieRepo.findAll();
    }

    @Override
    public Categorie saveOrUpdate(Categorie categorie) {
        return (Categorie) categorieRepo.save(categorie);
    }

    @Override
    public Optional<Categorie> getById(long id) {
        return categorieRepo.findById(id);
    }

    @Override
    public void delete(long id) {
        categorieRepo.deleteById(id);
    }

    @Override
    public boolean existsById(long id) {
        return categorieRepo.existsById(id);
    }
}
