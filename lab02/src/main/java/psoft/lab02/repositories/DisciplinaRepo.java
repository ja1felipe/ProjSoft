package psoft.lab02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import psoft.lab02.entities.disciplina.Disciplina;

import java.io.Serializable;

@Repository
public interface DisciplinaRepo<ID, T extends Serializable> extends JpaRepository<Disciplina, Long> {
}
