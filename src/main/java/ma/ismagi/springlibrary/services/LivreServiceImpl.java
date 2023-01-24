package ma.ismagi.springlibrary.services;

import ma.ismagi.springlibrary.models.Livre;
import ma.ismagi.springlibrary.repositories.LivreRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreServiceImpl implements LivreService {

    private LivreRepo livreRepo;
    public LivreServiceImpl(LivreRepo _livreRepo) {
        livreRepo = _livreRepo;
    }

    @Override
    public List<Livre> getAll() {
        return  livreRepo.findAll();
    }



    @Override
    public Livre saveOrUpdate(Livre livre) {
         return livreRepo.save(livre);
    }

    @Override
    public List<Livre> getByCategorieId(long id) {
        return livreRepo.findLivresByCategorie_Id(id);
    }

    @Override
    public boolean existsByIsbn(String isbn) {
        return livreRepo.existsByIsbn(isbn);
    }
}
