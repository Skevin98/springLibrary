package ma.ismagi.springlibrary.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdherentDTO {

    private long id;

    private String nom;

    private String prenom;

    private LocalDate date_naissance;

    private LocalDate date_inscription;

    private Long emprunt;

    private Long compte;
}
