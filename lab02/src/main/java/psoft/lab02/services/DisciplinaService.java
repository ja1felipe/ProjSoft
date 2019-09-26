package psoft.lab02.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import psoft.lab02.entities.disciplina.Disciplina;
import psoft.lab02.repositories.DisciplinaRepo;
import psoft.lab02.util.DisciplinaComparatorLike;
import psoft.lab02.util.DisciplinaComparatorNota;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Service
public class DisciplinaService {

    private DisciplinaRepo<Disciplina, Long> disciplinaDAO;

    public DisciplinaService(DisciplinaRepo<Disciplina, Long> disciplinaDAO){
        super();
        this.disciplinaDAO = disciplinaDAO;
    }

    @PostConstruct
    public void initDisciplina(){
        if(this.disciplinaDAO.count() == 0) {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Disciplina>> typeReference = new TypeReference<List<Disciplina>>() {
            };
            InputStream inputStream = ObjectMapper.class.getResourceAsStream("/json/disciplinas.json");
            try {
                List<Disciplina> disciplinas = mapper.readValue(inputStream, typeReference);
                this.disciplinaDAO.saveAll(disciplinas);
            } catch (IOException e) {
                System.out.println("DEU ERRO PORA");
            }
        }
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinaDAO.findAll();
    }

    public Disciplina getOneDisciplina(Long id) {
        Disciplina d = disciplinaDAO.findById(id).get();
        return d;
    }

    public Disciplina addLike(Long id) {
        Disciplina d = disciplinaDAO.findById(id).get();
        Integer likes = d.getLikes();
        d.setLikes(likes + 1);
        disciplinaDAO.saveAndFlush(d);
        return disciplinaDAO.findById(id).get();
    }

    public Disciplina updateNota(Long id, Double nota) {
        Disciplina d = disciplinaDAO.findById(id).get();
        d.setNota(nota);
        disciplinaDAO.saveAndFlush(d);
        return disciplinaDAO.findById(id).get();
    }

    public Disciplina addComent(Long id, String comentario) {
        Disciplina d = disciplinaDAO.findById(id).get();
        String comentarios = d.getComentarios();
        d.setComentarios(comentarios + "\n" + comentario);
        disciplinaDAO.saveAndFlush(d);
        return disciplinaDAO.findById(id).get();
    }

    public List<Disciplina> getRankDisciplinasNotas() {
        DisciplinaComparatorNota comparador = new DisciplinaComparatorNota();
        List<Disciplina> d = disciplinaDAO.findAll();
        d.sort(comparador);
        return d;
    }

    public List<Disciplina> getRankDisciplinasLikes() {
        DisciplinaComparatorLike comparador = new DisciplinaComparatorLike();
        List<Disciplina> d = disciplinaDAO.findAll();
        d.sort(comparador);
        return d;
    }
}
