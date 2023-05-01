package br.com.softblue.bluefood.domain.restaurante;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "categoria_restaurante")
public class CategoriaRestaurante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 20)
    private String nome;

    @NotNull
    @Size(max = 50)
    private  String imagem;

    @ManyToMany(mappedBy = "categorias")
    private Set<Restaurante> restaurante = new HashSet<>(0);
}
