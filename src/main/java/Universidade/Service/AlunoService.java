package Universidade.Service;

import Universidade.Model.Alunos;
import Universidade.Model.Cursos;
import Universidade.dto.request.AlunoRegistro;
import Universidade.respository.AlunoRepository;
import Universidade.respository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private final AlunoRepository alunoRepository;
    @Autowired
    private final CursoRepository cursoRepository;

    public AlunoService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public AlunoRegistro create(AlunoRegistro alunoRegistro) {
        Alunos cadastro = new Alunos();
        StringBuilder CodigoDoAluno = new StringBuilder();

            CodigoDoAluno.append("CEUMA@");
            for (int i = 0;i <=5 ; i++){
                int NAleatorio = (int)  (Math.random() * 9);
                CodigoDoAluno.append(NAleatorio);
            }
            CodigoDoAluno.append("ORG");

            cadastro.setCodigoDoAluno(CodigoDoAluno.toString());
            cadastro.setCep(alunoRegistro.getCep());
            cadastro.setEmail(alunoRegistro.getEmail());
            cadastro.setCpf(alunoRegistro.getCpf());
            cadastro.setEndereco(alunoRegistro.getEndereco());
            cadastro.setNome(alunoRegistro.getNome());
            cadastro.setNumeroDeTelefone(alunoRegistro.getTelefone());


            Long idCurso = alunoRegistro.getIdCurso();
            if (idCurso != null) {
                Optional<Cursos> cursoOptional = cursoRepository.findById(Math.toIntExact(idCurso));
                cursoOptional.ifPresent(cadastro::setId_Curso);
            }

            Alunos alunoSalvo = alunoRepository.save(cadastro);
            alunoRegistro.setIdCurso(alunoSalvo.getId_Curso() != null ? Long.valueOf(alunoSalvo.getId_Curso().getId()) : null);

            return alunoRegistro;

    }
    @Transactional
    public AlunoRegistro update(AlunoRegistro alunoRegistro,Integer id) {
        Alunos a = new Alunos();
        try {
            a = alunoRepository.getReferenceById(id);
            if (!alunoRepository.existsById(id)) {
                throw new EntityNotFoundException("Alunos com id " + id + " Não encontrado");
            }
            a.setCep(alunoRegistro.getCep());
            a.setEmail(alunoRegistro.getEmail());
            a.setCpf(alunoRegistro.getCpf());
            a.setEndereco(alunoRegistro.getEndereco());
            a.setNome(alunoRegistro.getNome());
            a.setNumeroDeTelefone(alunoRegistro.getTelefone());
            alunoRepository.save(a);
            return alunoRegistro;


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return alunoRegistro;
    }public void deletarAluno(Integer id) {
        Optional<Alunos> aluno = alunoRepository.findById(id);

        if (aluno != null) {
            alunoRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Aluno não encontrado com ID: " + id);
        }


    }
}
