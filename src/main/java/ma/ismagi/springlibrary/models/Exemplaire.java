package ma.ismagi.springlibrary.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import ma.ismagi.springlibrary.utils.Etat;


import java.util.List;

@Data
@Entity
@Table(name = "Exemplaire")
public class Exemplaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,name = "Etat")
    private Etat etat;

    @Column(nullable = false,name = "Prix_remplacement")
    private double prixRemplacement;

    @ManyToOne(targetEntity = Livre.class,fetch = FetchType.LAZY)
    @JsonBackReference
    private Livre livre;

    @OneToMany(targetEntity = Emprunt.class,cascade = CascadeType.ALL, mappedBy = "exemplaire")
    @JsonManagedReference
    private List<Emprunt> emprunts;


    public Exemplaire() {
        this.etat = Etat.Ok;
        this.prixRemplacement = 0.0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public double getPrixRemplacement() {
        return prixRemplacement;
    }

    public void setPrixRemplacement(double prixRemplacement) {
        this.prixRemplacement = prixRemplacement;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
}
