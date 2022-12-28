package ma.ismagi.springlibrary.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
