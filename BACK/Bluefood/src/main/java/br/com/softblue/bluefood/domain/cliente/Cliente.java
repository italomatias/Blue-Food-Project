package br.com.softblue.bluefood.domain.cliente;
import br.com.softblue.bluefood.domain.usuario.Usuario;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true , callSuper = true)
@Entity
public class Cliente extends Usuario {
    private String cpf;
    private String cep;
}
