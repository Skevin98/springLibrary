package ma.ismagi.springlibrary.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Data
@Entity
@Table(name = "Categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nom_ctgr;

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    @OneToMany(targetEntity = Livre.class,mappedBy = "categorie",cascade =CascadeType.ALL)
    private List<Livre> livres;
    public Categorie(){}
//Getter & setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom_ctgr() {
        return nom_ctgr;
    }

    public void setNom_ctgr(String nom_ctgr) {
        this.nom_ctgr = nom_ctgr;
    }
}
