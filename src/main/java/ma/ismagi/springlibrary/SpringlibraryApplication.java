package ma.ismagi.springlibrary;

import ma.ismagi.springlibrary.dto.EmpruntDTO;
import ma.ismagi.springlibrary.dto.ExemplaireDTO;
import ma.ismagi.springlibrary.models.Emprunt;
import ma.ismagi.springlibrary.models.Exemplaire;
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
				mapper -> mapper.map(src -> src.getLivre().getIsbn(),ExemplaireDTO::setLivre)
		);
		TypeMap<Emprunt, EmpruntDTO> propertyMapper2 =modelMapper.createTypeMap(Emprunt.class, EmpruntDTO.class);
		propertyMapper2.addMappings(
				mapper -> {
					mapper.map(src -> src.getAdherent().getId(), EmpruntDTO::setAdherent);
					mapper.map(src -> src.getExemplaire().getId(),EmpruntDTO::setExemplaire);
				}
		);
		return modelMapper;
	}


}
