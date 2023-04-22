package br.com.softblue.bluefood.domain.usuario;

import br.com.softblue.bluefood.util.StringUtils;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O Nome não pode ser vazio !")
    @Size(max = 80, message = "O nome não pode passar de 80 caracteres !")
    private String nome;

    @NotBlank(message = "O e-mail não pode ser vazio !")
    @Size(max = 80, message = "O e-mail não pode passar de 80 caracteres !")
    @Email(message = "O e-mail é inválido !")
    private String email;

    @NotBlank(message = "O senha não pode ser vazia !")
    @Size(max = 80, message = "O senha não pode passar de 80 caracteres !")
    private  String senha;

    @NotBlank(message = "O telefone não pode ser vazia !")
    @Pattern(regexp = "[0-9]{10,11}",message = "O telefone possui formato inválido !")
    @Column(length = 11 , nullable = false)
    private String telefone;

    public void encryptPassword(){
        this.senha = StringUtils.encrypt(this.senha);
    }

}
