package ma.ismagi.springlibrary.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Livre")
public class Livre {

    //id du livre = isbn = International Standard Book Number
    //pas besoin d'ajouter un autre attribut id
    @Column(length = 17)
    @Id
    private String isbn;

    //Completer les attributs restants ici



    @OneToMany(targetEntity = Exemplaire.class,cascade = CascadeType.ALL,mappedBy = "livre",fetch = FetchType.LAZY)
    @JsonManagedReference(value = "exemplaire-livre")
    //@JsonIgnore
    private List<Exemplaire> exemplaires;

    public Livre() {
    }

    public Livre(String isbn) {
        this.isbn = isbn;
    }

    //Generer les getter et les setters ici (alt+ins > getters and setters)
}
