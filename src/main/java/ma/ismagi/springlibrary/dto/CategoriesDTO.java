package ma.ismagi.springlibrary.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoriesDTO {
    private long id;
    @NotBlank(message = "Le nom est obligatoire")
    private String nom_ctgr;
}
