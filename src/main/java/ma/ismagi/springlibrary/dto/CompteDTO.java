package ma.ismagi.springlibrary.dto;

import lombok.Data;
import ma.ismagi.springlibrary.utils.Etat;

@Data
public class CompteDTO {

    private Long id_Cmpt;

    private String login;

    private String password;

    private Etat Active;

    private Long adherent;


}
