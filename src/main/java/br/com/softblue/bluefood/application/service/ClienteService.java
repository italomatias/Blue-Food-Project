package br.com.softblue.bluefood.application.service;

import br.com.softblue.bluefood.domain.cliente.Cliente;
import br.com.softblue.bluefood.domain.cliente.ClienteRepository;
import br.com.softblue.bluefood.domain.restaurante.Restaurante;
import br.com.softblue.bluefood.domain.restaurante.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Transactional
    public void saveCliente(Cliente cliente) throws  ValidationException{
        if(!validateEmail(cliente.getEmail(),cliente.getId())){
            throw new ValidationException("E-mail já cadastrado !");
        }

        if(cliente.getId()!= null){
            Cliente clientedb = clienteRepository.findById(cliente.getId()).orElseThrow();
            cliente.setSenha(clientedb.getSenha());
        }else{
            cliente.encryptPassword();
        }

        clienteRepository.save(cliente);
    }

    private boolean validateEmail(String email , Integer id){

        Restaurante restaurante = restauranteRepository.findByEmail(email);

        if (restaurante != null){
            return false;
        }

        Cliente cliente = clienteRepository.findByEmail(email);

        if (cliente != null){
            if (id == null){
                return  false;
            }
            else return cliente.getId().equals(id);
        }
        return true;
    }
}
