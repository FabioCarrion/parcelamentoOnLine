package bethaCode.javaspringideaparcelamentoonLine.repository;

import bethaCode.javaspringideaparcelamentoonLine.model.Cep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {
}
