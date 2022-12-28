package ma.ismagi.springlibrary.controllers;


import ma.ismagi.springlibrary.dto.EmpruntDTO;
import ma.ismagi.springlibrary.models.Emprunt;
import ma.ismagi.springlibrary.services.EmpruntService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/emprunt")
public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("/")
    public ResponseEntity<Emprunt> addEmprunt(@RequestBody Emprunt emprunt){
        Emprunt savedEmprunt = empruntService.saveOrUpdate(emprunt);
        return new ResponseEntity<>(savedEmprunt, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmpruntDTO>> getAll(){
        List<Emprunt> emprunts = empruntService.getAll();

        List<EmpruntDTO> ems = emprunts.stream()
                .map(
                        x->modelMapper.map(x, EmpruntDTO.class)
                ).collect(Collectors.toList());
        return new ResponseEntity<>(ems,HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpruntDTO> getById(@PathVariable("id") Long id){
        Optional<Emprunt> emprunt = empruntService.getById(id);
        if (emprunt.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        EmpruntDTO em = modelMapper.map(emprunt.get(), EmpruntDTO.class);
        return new ResponseEntity<>(em, HttpStatus.OK);
    }

}
