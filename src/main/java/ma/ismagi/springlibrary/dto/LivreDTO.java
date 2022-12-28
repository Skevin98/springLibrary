package ma.ismagi.springlibrary.dto;

import org.hibernate.validator.constraints.Length;

public class LivreDTO {
    @Length(min = 13,max = 13,message = "L'ISBN est un code à 13 chiffres.")
    private String isbn;
}
