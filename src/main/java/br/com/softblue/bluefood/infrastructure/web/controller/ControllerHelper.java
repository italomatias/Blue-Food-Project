package br.com.softblue.bluefood.infrastructure.web.controller;

import br.com.softblue.bluefood.domain.restaurante.CategoriaRestaurante;
import br.com.softblue.bluefood.domain.restaurante.CategoriaRestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;

import java.util.List;

public class ControllerHelper {

    public static void setEditMode (Model model , boolean isEdit ){
        model.addAttribute("editMode" , isEdit);
    }

    public static void addCategoriasToRequest(CategoriaRestauranteRepository repository , Model model){
        List<CategoriaRestaurante> categorias = repository.findAll(Sort.by("nome"));
        model.addAttribute("categorias",categorias);
    }
}
