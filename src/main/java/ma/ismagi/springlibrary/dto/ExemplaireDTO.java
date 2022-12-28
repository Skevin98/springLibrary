package ma.ismagi.springlibrary.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import ma.ismagi.springlibrary.models.Livre;
import ma.ismagi.springlibrary.utils.Etat;
import org.hibernate.validator.constraints.Length;

@Data
public class ExemplaireDTO {

    private long id;

    @Max(value = 2,message = "Doit être compris entre 0 et 2")
    @Min(value = 0, message = "Doit être compris entre 0 et 2")
    Etat etat;

    @Min(value = 0, message = "Le prix doit être positif")
    float prixRemplacement;

    String livre;
}
