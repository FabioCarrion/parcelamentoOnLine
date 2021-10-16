package bethaCode.javaspringideaparcelamentoonLine.repository;

import bethaCode.javaspringideaparcelamentoonLine.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long>{
}

