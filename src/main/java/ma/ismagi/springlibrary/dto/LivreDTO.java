package ma.ismagi.springlibrary.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

//A completer
@Data
public class LivreDTO {
    @Length(min = 13,max = 13,message = "L'ISBN est un code à 13 chiffres.")
    private String isbn;
    @NotBlank(message = "Le titre est obligatoire")
    private String titre;
    @NotBlank(message = "Le nom de l'auteur est obligatoire")
    private String auteur;
    @NotBlank(message ="l'id est obligatoire")
    private long categorie_id;
}
