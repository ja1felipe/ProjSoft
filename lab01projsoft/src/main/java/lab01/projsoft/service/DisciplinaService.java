package lab01.projsoft.service;

import lab01.projsoft.entities.Disciplina;
import lab01.projsoft.utility.DisciplinaCompartor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class DisciplinaService {
    private Map<Integer, Disciplina> disciplinas = new HashMap<>();
    private int id = 0;

    public Disciplina addDisciplina(JSONObject obj){
        Disciplina nova_disciplina = new Disciplina(this.id, obj);
        disciplinas.put(id, nova_disciplina);
        this.id += 1;
        return nova_disciplina;
    }

    public Disciplina deleteDisciplina(int id){
        Disciplina delete_disciplina = disciplinas.get(id);
        this.disciplinas.remove(id);
        return delete_disciplina;
    }

    public Object[] listDisciplinas(){
        return this.disciplinas.values().toArray();
    }

    public Disciplina getById(Integer id){
        if(this.disciplinas.containsKey(id)) {
            return this.disciplinas.get(id);
        }else {
            throw new NoSuchElementException();
        }
    }

    public Disciplina updateName(Integer id, String nome) {
        if(this.disciplinas.containsKey(id)) {
            this.disciplinas.get(id).setNome(nome);
            return this.disciplinas.get(id);
        }else {
            throw new NoSuchElementException();
        }

    }

    public Disciplina updateNota(Integer id, Double nota) {
        if(this.disciplinas.containsKey(id)) {
            this.disciplinas.get(id).setNota(nota);
            return this.disciplinas.get(id);
        }else {
            throw new NoSuchElementException();
        }
    }

    public Disciplina deleteById(Integer id) {
        if(this.disciplinas.containsKey(id)){
            Disciplina removed = this.disciplinas.get(id);
            this.disciplinas.remove(id);
            return removed;
        }else {
            throw new NoSuchElementException();
        }
    }

    public Object[] listDisciplinasRank(){
        DisciplinaCompartor comparator = new DisciplinaCompartor();
        Object[] arr = this.disciplinas.values().toArray();
        Arrays.sort(arr, comparator);
        return arr;
    }
}
