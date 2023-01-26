package ma.ismagi.springlibrary.controllers;

import ma.ismagi.springlibrary.dto.CategoriesDTO;
import ma.ismagi.springlibrary.models.Categorie;
import ma.ismagi.springlibrary.services.CategorieService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/categories")
public class CategorieController {
 private CategorieService categorieService;
 private ModelMapper modelMapper;
  public CategorieController(CategorieService _categorieService,ModelMapper _modelMapper){
      categorieService=_categorieService;
      modelMapper=_modelMapper;
  }
    @GetMapping("/")
    public ResponseEntity<List<CategoriesDTO>> getAll(){
        List<Categorie> categories = categorieService.getAll();

        List<CategoriesDTO> cts = categories.stream()
                .map(
                        x->modelMapper.map(x, CategoriesDTO.class)
                ).collect(Collectors.toList());
        return new ResponseEntity<>(cts, HttpStatus.OK);

    }

    @PostMapping("/")
    public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie categorie){
        Categorie savedCategorie = categorieService.saveOrUpdate(categorie);
        return new ResponseEntity<>(savedCategorie, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriesDTO> updateCategorie(@PathVariable("id") Long id, @RequestBody Categorie categorie){
        if (!id.equals(categorie.getId()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (!categorieService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        CategoriesDTO updatedCa = modelMapper.map(categorieService.saveOrUpdate(categorie), CategoriesDTO.class);
        return new ResponseEntity<>(updatedCa, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoriesDTO> getById(@PathVariable("id") Long id){
        Optional<Categorie> categorie = categorieService.getById(id);
        if (categorie.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        CategoriesDTO ca = modelMapper.map(categorie.get(), CategoriesDTO.class);
        return new ResponseEntity<>(ca, HttpStatus.OK);
    }
}
