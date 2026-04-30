import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Pessoa {
    private int codigo;
    private String nome;
    private String fone;
    private String email;

}

