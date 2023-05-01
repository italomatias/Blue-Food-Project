package br.com.softblue.bluefood.domain.restaurante;

import br.com.softblue.bluefood.domain.usuario.Usuario;
import br.com.softblue.bluefood.infrastructure.web.validator.UploadConstraint;
import br.com.softblue.bluefood.util.Filetype;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true , callSuper = true)
@Entity
@Table(name = "restaurante")
public class Restaurante extends Usuario {
    @NotBlank(message = "O CNPJ não pode ser vazio !")
    @Pattern(regexp = "[0-9]{14}",message = "O CNPJ possui formato inválido !")
    @Column(length = 14)
    private String cnpj;

    @Size(max = 80)
    private String logotipo;

    @UploadConstraint(acceptedTypes = {Filetype.PNG , Filetype.JPEG} , message = "Não é um arquivo de imagem válido!")
    private transient MultipartFile logotipoFile;

    @NotNull(message = "A taxa de entrega deve ser informada !")
    @Min(0)
    @Max(99)
    private BigDecimal taxaEntrega;

    @NotNull(message = "A tempo de entrega deve ser informado !")
    @Min(0)
    @Max(120)
    private Integer tempoEntregaBase;

    @ManyToMany
    @JoinTable( name = "restaurante_has_categoria",
                joinColumns = @JoinColumn(name = "restaurante_id"),
                inverseJoinColumns = @JoinColumn(name = "categoria_restaurante_id"))
    @Size(min = 1,message = "O restaurente precisa ter ao menos uma categoria !")
    @ToString.Exclude
    private Set<CategoriaRestaurante> categorias = new HashSet<>(0);

    public void setLogotipoFile() {
        if (getId() == null){
            throw new IllegalStateException("É necessário salvar o registro !");
        }

        this.logotipo = String.format("%04d-logo.%s",getId(), Filetype.of(logotipoFile.getContentType()).getExtension());
    }
}
