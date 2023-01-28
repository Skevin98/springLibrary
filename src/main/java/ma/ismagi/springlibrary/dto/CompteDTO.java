package ma.ismagi.springlibrary.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import ma.ismagi.springlibrary.utils.Etat;

@Data
public class CompteDTO {

    private Long id;

    private String login;

    private String password;

    private Boolean active;


    @NotBlank(message = "L'id de l'adherent est obligatoire")
    private Long adherent;

    private String adherent_nom;

    private String adherent_prenom;


}
