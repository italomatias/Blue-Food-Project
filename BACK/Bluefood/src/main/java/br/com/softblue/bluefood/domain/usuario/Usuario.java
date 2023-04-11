package br.com.softblue.bluefood.domain.usuario;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public class Usuario implements Serializable {
    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private String nome;
    private String email;
    private  String senha;
    private String telefone;

}