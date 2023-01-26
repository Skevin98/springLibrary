package ma.ismagi.springlibrary.services;

import ma.ismagi.springlibrary.models.Compte;
import ma.ismagi.springlibrary.repositories.CompteRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteServiceImpl implements CompteService {

    private CompteRepo compteRepo;

    public CompteServiceImpl(CompteRepo compteRepo){ this.compteRepo = compteRepo; }
    @Override
    public List<Compte> getAll() {
        return compteRepo.findAll();
    }

    @Override
    public Optional<Compte> getById(long id) {
        return compteRepo.findById(id);
    }

    @Override
    public List<Compte> getByAdherentId(long id) {
        return compteRepo.findCompteByAdherent_id(id);
    }

    @Override
    public Compte saveOrUpdate(Compte compte) {
        return compteRepo.save(compte);
    }

    @Override
    public void delete(long id) {
        Optional<Compte> compte=getById(id);
        if(compte.isPresent())
            compteRepo.delete(compte.get());

    }

    @Override
    public Boolean existsById(long id) {
        return compteRepo.existsById(id);
    }
}
