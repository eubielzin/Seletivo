package Universidade.controller;

import Universidade.Model.Cursos;
import Universidade.Service.CursoService;
import Universidade.dto.request.CursoRegistro;
import Universidade.respository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CursoService cursoService;
    @GetMapping
    public Iterable<Cursos> listaCursos(){
        return cursoRepository.findAll();
    }
    @GetMapping(path = "/{id}")
    public Optional<Cursos> listaCursos(@PathVariable Integer    id){
        return cursoRepository.findById(id);
    }
    @PostMapping
    public CursoRegistro create(@RequestBody CursoRegistro cursoRegistro){
        cursoService.create(cursoRegistro);
        return  cursoRegistro;

    }
    @PutMapping("/{id}")
    public CursoRegistro update(@RequestBody CursoRegistro cursoRegistro ,@PathVariable Long id){
        cursoService.update(cursoRegistro);
        return  cursoRegistro;

    }


}
