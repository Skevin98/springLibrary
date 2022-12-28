package ma.ismagi.springlibrary.services;

import ma.ismagi.springlibrary.models.Emprunt;

import java.util.List;
import java.util.Optional;

public class EmpruntServiceImpl implements EmpruntService{
    @Override
    public List<Emprunt> getByIsbn(String isbn) {
        return null;
    }

    @Override
    public Optional<Emprunt> getById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Emprunt> getByAdherentId(long id) {
        return null;
    }

    @Override
    public List<Emprunt> getByExemplaireId(long id) {
        return null;
    }

    @Override
    public Emprunt saveOrUpdate(Emprunt emprunt) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Boolean existsById(long id) {
        return null;
    }
}
