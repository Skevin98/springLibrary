package ma.ismagi.springlibrary;

import ma.ismagi.springlibrary.dto.*;
import ma.ismagi.springlibrary.models.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringlibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringlibraryApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){

		ModelMapper modelMapper = new ModelMapper();
		TypeMap<Exemplaire, ExemplaireDTO> propertyMapper =modelMapper.createTypeMap(Exemplaire.class, ExemplaireDTO.class);
		propertyMapper.addMappings(
				mapper -> {
					mapper.map(src -> src.getLivre().getIsbn(), ExemplaireDTO::setLivre);
					mapper.map(src -> src.getLivre().getTitre(), ExemplaireDTO::setTitre_livre);
				}
		);
		TypeMap<Emprunt, EmpruntDTO> propertyMapper2 =modelMapper.createTypeMap(Emprunt.class, EmpruntDTO.class);
		propertyMapper2.addMappings(
				mapper -> {
					mapper.map(src -> src.getAdherent().getId(), EmpruntDTO::setAdherent);
					mapper.map(src -> src.getExemplaire().getId(),EmpruntDTO::setExemplaire);
				}
		);
		TypeMap<Livre, LivreDTO> propertyMapper3 =modelMapper.createTypeMap(Livre.class, LivreDTO.class);
		propertyMapper3.addMappings(
				mapper -> {
					mapper.map(src -> src.getCategorie().getId(), LivreDTO::setCategorie);
					mapper.map(src -> src.getCategorie().getNom_ctgr(), LivreDTO::setNom_ctrg);
				}
		);

		TypeMap<Adherent, AdherentDTO> propertyMapper4 =modelMapper.createTypeMap(Adherent.class, AdherentDTO.class);
		propertyMapper4.addMappings(
				mapper -> {
					mapper.map(src -> src.getCompte().getId(), AdherentDTO::setCompte);
				}
		);

		TypeMap<Compte, CompteDTO> propertyMapper5 =modelMapper.createTypeMap(Compte.class, CompteDTO.class);
		propertyMapper5.addMappings(
				mapper -> {
					mapper.map(src -> src.getAdherent().getId(), CompteDTO::setAdherent);
					mapper.map(src -> src.getAdherent().getNom(), CompteDTO::setAdherent_nom);
					mapper.map(src -> src.getAdherent().getPrenom(), CompteDTO::setAdherent_prenom);
				}
		);


		return modelMapper;
	}


}
