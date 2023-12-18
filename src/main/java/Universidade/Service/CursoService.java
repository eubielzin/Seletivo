package Universidade.Service;

import Universidade.Model.Cursos;
import Universidade.dto.request.CursoRegistro;
import Universidade.respository.AlunoRepository;
import Universidade.respository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private final AlunoRepository alunoRepository;
    @Autowired
    private final CursoRepository cursoRepository;

    public CursoService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }
    @Transactional
    public CursoRegistro create(CursoRegistro cursoRegistro) {
        Cursos CriarCursos = new Cursos();
        Optional<Cursos> curso = cursoRepository.findCursoByNomeDoCurso(cursoRegistro.getNomeDoCurso());
        if (curso.isEmpty()){
            CriarCursos.setNomeDoCurso(cursoRegistro.getNomeDoCurso());
            CriarCursos.setCargaHoraria(cursoRegistro.getCargaHoraria());
            cursoRepository.save(CriarCursos);
            return cursoRegistro;
        }
        return null;
    }
    @Transactional
    public CursoRegistro update(CursoRegistro cursoRegistro) {
        Cursos AtualizarcCursos = new Cursos();
        Optional<Cursos> curso = cursoRepository.findCursoByNomeDoCurso(cursoRegistro.getNomeDoCurso());
        if (curso.isEmpty()){
            throw new EntityNotFoundException("Aluno não encontrado com ID: " );
        }else{
            AtualizarcCursos.setNomeDoCurso(cursoRegistro.getNomeDoCurso());
            AtualizarcCursos.setCargaHoraria(cursoRegistro.getCargaHoraria());
            cursoRepository.save(AtualizarcCursos);
            return cursoRegistro;
        }
    }
}
