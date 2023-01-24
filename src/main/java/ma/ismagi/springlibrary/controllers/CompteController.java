package ma.ismagi.springlibrary.controllers;

import ma.ismagi.springlibrary.dto.CompteDTO;
import ma.ismagi.springlibrary.models.Compte;
import ma.ismagi.springlibrary.services.CompteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/compte")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/")
    public ResponseEntity<Compte> addCompte(@RequestBody Compte compte){
        Compte saveCompte = compteService.saveOrUpdate(compte);
        return new ResponseEntity<>(saveCompte, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CompteDTO>> getAll(){
        List<Compte> comptes = compteService.getAll();

        List<CompteDTO> compt = comptes.stream()
                .map(
                        c->modelMapper.map(c, CompteDTO.class)
                ).collect(Collectors.toList());
        return new ResponseEntity<>(compt,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CompteDTO> getById(@PathVariable("id") Long id){
        Optional<Compte> compte = compteService.getById(id);
        if(compte.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        CompteDTO cmpt = modelMapper.map(compte.get(), CompteDTO.class);
        return new ResponseEntity<>(cmpt, HttpStatus.OK);
    }
}
