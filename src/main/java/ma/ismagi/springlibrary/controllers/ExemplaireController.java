package ma.ismagi.springlibrary.controllers;

import ma.ismagi.springlibrary.dto.ExemplaireDTO;
import ma.ismagi.springlibrary.models.Exemplaire;
import ma.ismagi.springlibrary.services.ExemplaireService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/exemplaire")
public class ExemplaireController {

    @Autowired
    private ExemplaireService exemplaireService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("/")
    public ResponseEntity<Exemplaire> addExemplaire(@RequestBody Exemplaire exemplaire){
        Exemplaire savedExemplaire = exemplaireService.saveOrUpdate(exemplaire);
        return new ResponseEntity<>(savedExemplaire, HttpStatus.OK);
    }

    @GetMapping("/byisbn/{isbn}")
    public ResponseEntity<List<ExemplaireDTO>> getByIsbn(@PathVariable("isbn") String isbn){
        List<Exemplaire> exemplaires = exemplaireService.getByIsbn(isbn);


        List<ExemplaireDTO> e = exemplaires.stream()
                .map(
                        x->modelMapper.map(x,ExemplaireDTO.class)
                ).collect(Collectors.toList());
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExemplaireDTO> getById(@PathVariable("id") Long id){
        Optional<Exemplaire> exemplaire = exemplaireService.getById(id);
        if (exemplaire.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        ExemplaireDTO ex = modelMapper.map(exemplaire.get(), ExemplaireDTO.class);
        return new ResponseEntity<>(ex, HttpStatus.OK);
    }



    @PutMapping("/{id}")
    public ResponseEntity<ExemplaireDTO> updateExemplaire(@PathVariable("id") Long id,@RequestBody Exemplaire exemplaire){
        if (!id.equals(exemplaire.getId()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (!exemplaireService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        ExemplaireDTO updatedEx = modelMapper.map(exemplaireService.saveOrUpdate(exemplaire), ExemplaireDTO.class);
        return new ResponseEntity<>(updatedEx, HttpStatus.OK);


    }



    @DeleteMapping("/{id}")
    public ResponseEntity deleteExemplaire(@PathVariable("id") Long id){
        Optional<Exemplaire> exemplaire = exemplaireService.getById(id);
        if (exemplaire.isPresent()) {
            exemplaireService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
