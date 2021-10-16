package bethaCode.javaspringideaparcelamentoonLine.enterprise;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id //Chave primária da entidade
    @GeneratedValue(strategy = GenerationType.AUTO) // Faz o autoincremento do Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
