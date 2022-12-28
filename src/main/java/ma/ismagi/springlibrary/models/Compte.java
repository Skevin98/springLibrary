package ma.ismagi.springlibrary.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
