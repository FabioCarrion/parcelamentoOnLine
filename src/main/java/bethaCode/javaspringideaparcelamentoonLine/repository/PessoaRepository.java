package bethaCode.javaspringideaparcelamentoonLine.repository;

import bethaCode.javaspringideaparcelamentoonLine.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
