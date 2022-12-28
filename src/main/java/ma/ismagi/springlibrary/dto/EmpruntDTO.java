package ma.ismagi.springlibrary.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import ma.ismagi.springlibrary.models.Adherent;
import ma.ismagi.springlibrary.models.Exemplaire;
import ma.ismagi.springlibrary.utils.Etat;

import java.time.LocalDate;


@Data
public class EmpruntDTO {

    private long id;

    private LocalDate dateEmprunt;

    private LocalDate dateRetourPrevue;

    private LocalDate dateRetourEffective;

    @Max(value = 2,message = "Doit être compris entre 0 et 2")
    @Min(value = 0, message = "Doit être compris entre 0 et 2")
    private Etat etatRetour;

    private String notes;

    private Long exemplaire;

    private Long adherent;
}
