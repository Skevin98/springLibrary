package ma.ismagi.springlibrary.controllers;

import ma.ismagi.springlibrary.dto.ExemplaireDTO;
import ma.ismagi.springlibrary.dto.LivreDTO;
import ma.ismagi.springlibrary.models.Exemplaire;
import ma.ismagi.springlibrary.models.Livre;
import ma.ismagi.springlibrary.services.LivreService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/livres")
public class LivreController {
    private LivreService livreService;
    private ModelMapper modelMapper;

    public LivreController(LivreService _livreService,ModelMapper _modelMapper){
        livreService=_livreService;
        modelMapper=_modelMapper;
    }
    @GetMapping("/")
    public ResponseEntity<List<LivreDTO>> getAll(){
        List<Livre> livres = livreService.getAll();

        List<LivreDTO> lvs = livres.stream()
                .map(
                        x->modelMapper.map(x, LivreDTO.class)
                ).collect(Collectors.toList());
        return new ResponseEntity<>(lvs, HttpStatus.OK);

    }
    @PostMapping("/")
    public ResponseEntity<Livre> addLivre(@RequestBody Livre livre){
        Livre savedLivre = livreService.saveOrUpdate(livre);
        return new ResponseEntity<>(savedLivre, HttpStatus.OK);
    }
    @PutMapping("/{isbn}")
    public ResponseEntity<LivreDTO> updateLivre(@PathVariable("isbn") String isbn, @RequestBody Livre livre){
        if (!isbn.equals(livre.getIsbn()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (!livreService.existsByIsbn(isbn))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        LivreDTO updatedLi = modelMapper.map(livreService.saveOrUpdate(livre), LivreDTO.class);
        return new ResponseEntity<>(updatedLi, HttpStatus.OK);


    }

}
