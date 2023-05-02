package br.com.softblue.bluefood.domain.cliente;
import br.com.softblue.bluefood.domain.usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true , callSuper = true)
@Entity
public class Cliente extends Usuario {
    @NotBlank(message = "O CPF não pode ser vazio !")
    @Pattern(regexp = "[0-9]{11}",message = "O CPF possui formato inválido !")
    @Column(length = 11)
    private String cpf;

    @NotBlank(message = "O CEP não pode ser vazio !")
    @Pattern(regexp = "[0-9]{8}",message = "O CPF possui formato inválido !")
    @Column(length = 8)
    private String cep;
}
