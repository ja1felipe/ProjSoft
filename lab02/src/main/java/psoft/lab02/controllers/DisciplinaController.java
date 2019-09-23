package psoft.lab02.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import psoft.lab02.entities.disciplina.Disciplina;
import psoft.lab02.entities.disciplina.DisciplinaComent;
import psoft.lab02.entities.disciplina.DisciplinaNota;
import psoft.lab02.services.DisciplinaService;

import java.util.List;

@RestController
public class DisciplinaController {
    private DisciplinaService discService;

    public DisciplinaController(DisciplinaService service){
        super();
        this.discService = service;
    }

    @GetMapping("api/disciplinas")
    public ResponseEntity<List<Disciplina>> getDisciplinas(){
        List<Disciplina> disciplinas = discService.getDisciplinas();
        return new ResponseEntity<>(disciplinas, HttpStatus.OK);
    }

    @GetMapping("api/disciplinas/{id}")
    public ResponseEntity<Disciplina> getOneDisciplina(@RequestParam Long id){
        Disciplina d = discService.getOneDisciplina(id);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @PutMapping("api/disciplinas/{id}/likes")
    public ResponseEntity<Disciplina> addLike(@RequestParam Long id){
        Disciplina d = discService.addLike(id);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @PutMapping("api/disciplinas/{id}/nota")
    public ResponseEntity<Disciplina> updateNota(@RequestParam Long id, @RequestBody DisciplinaNota dto){
        Disciplina d = discService.updateNota(id, dto.getNota());
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @PostMapping("api/disciplinas/{id}/comentarios")
    public ResponseEntity<Disciplina> addComent(@RequestParam Long id, @RequestBody DisciplinaComent dto){
        Disciplina d = discService.addComent(id, dto.getComentarios());
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

//    @GetMapping("api/disciplinas/ranking/notas")
//    public ResponseEntity<List<Disciplina>> getRankDisciplinasNotas(){
//        List<Disciplina> disciplinas = discService.getRankDisciplinasNotas();
//        return new ResponseEntity<>(disciplinas, HttpStatus.OK);
//    }

//    @GetMapping("api/disciplinas/ranking/likes")
//    public ResponseEntity<List<Disciplina>> getRankDisciplinasLikes(){
//        List<Disciplina> disciplinas = discService.getRankDisciplinasLikes();
//        return new ResponseEntity<>(disciplinas, HttpStatus.OK);
//    }
}
