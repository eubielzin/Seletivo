package Universidade.respository;

import Universidade.Model.Alunos;
import Universidade.Model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@EnableJpaRepositories
public interface AlunoRepository extends JpaRepository<Alunos,Integer> {


}
