package ma.ismagi.springlibrary.services;

import ma.ismagi.springlibrary.models.Emprunt;
import ma.ismagi.springlibrary.repositories.EmpruntRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmpruntServiceImpl implements EmpruntService{

    private EmpruntRepo empruntRepo;

    public EmpruntServiceImpl(EmpruntRepo empruntRepo) {
        this.empruntRepo = empruntRepo;
    }

    @Override
    public List<Emprunt> getAll() {
        return empruntRepo.findAll();
    }

    @Override
    public Optional<Emprunt> getById(long id) {
        return empruntRepo.findById(id);
    }

    @Override
    public List<Emprunt> getByAdherentId(long id) {
        return empruntRepo.findEmpruntsByAdherent_Id(id);
    }

    @Override
    public List<Emprunt> getByExemplaireId(long id) {
        return empruntRepo.findEmpruntsByExemplaire_Id(id);
    }

    @Override
    public Emprunt saveOrUpdate(Emprunt emprunt) {
        return empruntRepo.save(emprunt);
    }

    @Override
    public void delete(long id) {
        Optional<Emprunt> emprunt = getById(id);
        if (emprunt.isPresent())
            empruntRepo.delete(emprunt.get());


    }

    @Override
    public Boolean existsById(long id) {
        return empruntRepo.existsById(id);
    }
}
