package ma.ismagi.springlibrary.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import ma.ismagi.springlibrary.utils.Etat;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Emprunt")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDate dateEmprunt;

    @Column(nullable = false)
    private LocalDate dateRetourPrevue;

    private LocalDate dateRetourEffective;

    private Etat etatRetour;

    @Column(length = 130)
    private String notes;

    @ManyToOne(targetEntity = Exemplaire.class,fetch = FetchType.LAZY)
    @JsonBackReference
    private Exemplaire exemplaire;

    @ManyToOne(targetEntity = Adherent.class,fetch = FetchType.LAZY)
    @JsonBackReference
    private Adherent adherent;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDate getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    public void setDateRetourPrevue(LocalDate dateRetourPrevue) {
        this.dateRetourPrevue = dateRetourPrevue;
    }

    public LocalDate getDateRetourEffective() {
        return dateRetourEffective;
    }

    public void setDateRetourEffective(LocalDate dateRetourEffective) {
        this.dateRetourEffective = dateRetourEffective;
    }

    public Etat getEtatRetour() {
        return etatRetour;
    }

    public void setEtatRetour(Etat etatRetour) {
        this.etatRetour = etatRetour;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }
}
