package ma.ismagi.springlibrary.controllers;

import ma.ismagi.springlibrary.dto.AdherentDTO;
import ma.ismagi.springlibrary.models.Adherent;
import ma.ismagi.springlibrary.services.AdherentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/adherent")
public class AdherentController {

    @Autowired
    private AdherentService adherentService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/")
    public ResponseEntity<Adherent> addAdherent(@RequestBody Adherent adherent){
        Adherent saveAdherent = adherentService.saveOrUpdate(adherent);
        return new ResponseEntity<>(saveAdherent, HttpStatus.OK);

    }

    @GetMapping("/")
    public ResponseEntity<List<AdherentDTO>> getAll(){
        List<Adherent> adherents = adherentService.getAll();

        List<AdherentDTO> adr = adherents.stream()
                .map(
                        a->modelMapper.map(a, AdherentDTO.class)
                ).collect(Collectors.toList());
        return new ResponseEntity<>(adr,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<AdherentDTO> getById(@PathVariable("id") Long id){
        Optional<Adherent> adherents = adherentService.getById(id);
        if(adherents.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        AdherentDTO adr = modelMapper.map(adherents.get(), AdherentDTO.class);
        return new ResponseEntity<>(adr,HttpStatus.OK);

    }


}
