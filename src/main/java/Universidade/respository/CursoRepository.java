package Universidade.respository;

import Universidade.Model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface CursoRepository extends JpaRepository<Cursos,Integer> {

//    @Query(nativeQuery = true, value = "SELECT * FROM Cursos WHERE Nome_Do_Curso = :nomeDoCurso")
//    Optional<Cursos> findByNomeDoCurso(String nomeDoCurso);

    Optional<Cursos> findCursoByNomeDoCurso(String nomeDoCurso);



}
