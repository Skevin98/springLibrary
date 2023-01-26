package ma.ismagi.springlibrary.services;

import ma.ismagi.springlibrary.models.Adherent;
import ma.ismagi.springlibrary.repositories.AdherentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdherentServiceImpl implements AdherentService{

    private AdherentRepo adherentRepo;

    public AdherentServiceImpl(AdherentRepo adherentRepo){ this.adherentRepo = adherentRepo; }
    @Override
    public List<Adherent> getAll() {
        return adherentRepo.findAll();
    }

    @Override
    public Optional<Adherent> getById(long id) {
        return adherentRepo.findById(id);
    }

    @Override
    public List<Adherent> getByCompteId(long id) {
        return adherentRepo.findAdherentByCompte_id(id);
    }



    @Override
    public Adherent saveOrUpdate(Adherent adherent) {
        return adherentRepo.save(adherent);
    }

    @Override
    public void delete(long id) {
        Optional<Adherent> adherent=getById(id);
        if(adherent.isPresent())
            adherentRepo.delete(adherent.get());

    }

    @Override
    public Boolean existsById(long id) {
        return adherentRepo.existsById(id);
    }
}
