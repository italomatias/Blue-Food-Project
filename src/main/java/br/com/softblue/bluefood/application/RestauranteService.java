package br.com.softblue.bluefood.application;

import br.com.softblue.bluefood.domain.cliente.Cliente;
import br.com.softblue.bluefood.domain.restaurante.Restaurante;
import br.com.softblue.bluefood.domain.restaurante.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private ImageService imageService;

    public void saveRestaurante(Restaurante restaurante) throws  ValidationException{
        if(!validateEmail(restaurante.getEmail(),restaurante.getId())){
            throw new ValidationException("E-mail já cadastrado !");
        }

        if(restaurante.getId()!= null){
            Restaurante restdb = restauranteRepository.findById(restaurante.getId()).orElseThrow();
            restaurante.setSenha(restdb.getSenha());
        }else{
            restaurante.encryptPassword();
            restaurante = restauranteRepository.save(restaurante);
            restaurante.setLogotipoFile();
            imageService.uploadLogotipo(restaurante.getLogotipoFile(),restaurante.getLogotipo());
        }


    }

    private boolean validateEmail(String email , Integer id){
        Restaurante restaurante = restauranteRepository.findByEmail(email);

        if (restaurante != null){
            if (id == null){
                return  false;
            }
            else return restaurante.getId().equals(id);
        }
        return true;
    }
}
