package ma.ismagi.springlibrary.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.ismagi.springlibrary.models.Exemplaire;
import ma.ismagi.springlibrary.models.Livre;
import ma.ismagi.springlibrary.repositories.ExemplaireRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExemplaireServiceImpl implements ExemplaireService{

    ExemplaireRepo exemplaireRepo;

    public ExemplaireServiceImpl(ExemplaireRepo exemplaireRepo) {
        this.exemplaireRepo = exemplaireRepo;
    }

    @Override
    public List<Exemplaire> getByIsbn(String isbn) {
        return exemplaireRepo.findExemplairesByLivre_Isbn(isbn);
    }

    @Override
    public Optional<Exemplaire> getById(long id) {
        return exemplaireRepo.findById(id);
    }

    @Override
    public Exemplaire saveOrUpdate(Exemplaire exemplaire) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Livre livre = objectMapper.convertValue(exemplaire.getLivre(), Livre.class);
//        exemplaire.setLivre(livre);
        return exemplaireRepo.save(exemplaire);
    }

    @Override
    public void delete(long id) {
        Optional<Exemplaire> exemplaire = getById(id);
        if (exemplaire.isPresent())
            exemplaireRepo.delete(exemplaire.get());

    }

    @Override
    public Boolean existsById(long id) {
        return exemplaireRepo.existsById(id);
    }
}
