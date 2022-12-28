package ma.ismagi.springlibrary.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Adherent")
public class Adherent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    //Completer les attributs restants ici


    @OneToMany(targetEntity = Emprunt.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "adherent")
    @JsonManagedReference(value = "adherent-emprunt")
    private List<Emprunt> emprunts;


    public Adherent() {
    }

    public Adherent(long id) {
        this.id = id;
    }


    //Generer les getter et les setters ici (alt+ins > getters and setters)
}
