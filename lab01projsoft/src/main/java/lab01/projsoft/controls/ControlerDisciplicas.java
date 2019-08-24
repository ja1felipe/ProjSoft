package lab01.projsoft.controls;

import lab01.projsoft.entities.Disciplina;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lab01.projsoft.service.DisciplinaService;

import java.util.NoSuchElementException;


@RestController
public class ControlerDisciplicas {

    private DisciplinaService service = new DisciplinaService();
    private JSONParser parser = new JSONParser();

    @PostMapping("/v1/api/disciplinas")
    public ResponseEntity<Disciplina> addDisciplina(@RequestBody String json) throws ParseException {
        JSONObject jsonObj = (JSONObject) this.parser.parse(json);
        return new ResponseEntity<>(this.service.addDisciplina(jsonObj), HttpStatus.CREATED);
    }

    @RequestMapping("/v1/api/disciplinas")
    public ResponseEntity<Object[]> getDisciplicas(){
        return new ResponseEntity<>(service.listDisciplinas(), HttpStatus.OK);
    }

    @RequestMapping("/v1/api/disciplinas/{idDisc}")
    public ResponseEntity<Disciplina> getDisciplicaById(@PathVariable(name="idDisc") Integer id){
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.resolve(400));
        }
    }

    @PutMapping("/v1/api/disciplinas/{idDisc}/nome")
    public ResponseEntity<Disciplina> updateDisciplicaName(@PathVariable(name="idDisc") Integer id, @RequestBody String json) throws ParseException{
        JSONObject jsonObj = (JSONObject) this.parser.parse(json);
        try {
            return new ResponseEntity<>(service.updateName(id, (String) jsonObj.get("nome")), HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.resolve(400));
        }
    }

    @PutMapping("/v1/api/disciplinas/{idDisc}/nota")
    public ResponseEntity<Disciplina> updateDisciplicaNota(@PathVariable(name="idDisc") Integer id, @RequestBody String json) throws ParseException{
        JSONObject jsonObj = (JSONObject) this.parser.parse(json);
        try {
            return new ResponseEntity<>(service.updateNota(id, (Double) jsonObj.get("nota")), HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.resolve(400));
        }
    }

    @DeleteMapping("/v1/api/disciplinas/{idDisc}")
    public ResponseEntity<Disciplina> deleteDisciplina(@PathVariable(name="idDisc") Integer id){
        try {
            return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.resolve(400));
        }
    }

    @RequestMapping("/v1/api/disciplinas/rank")
    public ResponseEntity<Object[]> getDisciplicasRank(){
        return new ResponseEntity<>(service.listDisciplinasRank(), HttpStatus.OK);
    }

}
