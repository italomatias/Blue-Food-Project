package br.com.softblue.bluefood.application;

import br.com.softblue.bluefood.domain.cliente.Cliente;
import br.com.softblue.bluefood.domain.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
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
