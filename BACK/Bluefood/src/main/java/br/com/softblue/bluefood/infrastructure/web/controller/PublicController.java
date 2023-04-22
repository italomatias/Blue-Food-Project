package br.com.softblue.bluefood.infrastructure.web.controller;

import br.com.softblue.bluefood.application.ClienteService;
import br.com.softblue.bluefood.application.ValidationException;
import br.com.softblue.bluefood.domain.cliente.Cliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/public")
public class PublicController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente/new")
    public String newCliente(Model model){
        model.addAttribute("cliente", new Cliente());
        ControllerHelper.setEditMode(model,false);
        return "clientecadastro";
    }
    @PostMapping(path = "/cliente/save")
    public String saveCliente(@ModelAttribute("cliente") @Valid Cliente cliente, Errors erros , Model model){

        if(!erros.hasErrors()){
            try {
                clienteService.saveCliente(cliente);
                model.addAttribute("msg", "Cliente salvo com sucesso!");
            }catch (ValidationException e){
                erros.rejectValue("email",null,e.getMessage());
            }
        }

        ControllerHelper.setEditMode(model,false);
        return "clientecadastro";
    }
}
