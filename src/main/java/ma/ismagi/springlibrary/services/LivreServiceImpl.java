package ma.ismagi.springlibrary.services;

import ma.ismagi.springlibrary.models.Livre;
import ma.ismagi.springlibrary.repositories.LivreRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Livre> getByIsbn(String isbn) {
        return livreRepo.findById(isbn);
    }


    @Override
    public Livre saveOrUpdate(Livre livre) {
         return livreRepo.save(livre);
    }

    @Override
    public List<Livre> getByCategorie(long id) {
        return livreRepo.findLivresByCategorie_Id(id);
    }

    @Override
    public boolean existsByIsbn(String isbn) {
        return livreRepo.existsByIsbn(isbn);
    }
}
