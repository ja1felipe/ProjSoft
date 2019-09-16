package psoft.lab02.services;

import org.springframework.stereotype.Service;
import psoft.lab02.entities.disciplina.Disciplina;
import psoft.lab02.repositories.DisciplinaRepo;

import java.util.List;
import java.util.Optional;


@Service
public class DisciplinaService {

    private DisciplinaRepo<Disciplina, Long> disciplinaDAO;

    public DisciplinaService(DisciplinaRepo<Disciplina, Long> disciplinaDAO){
        super();
        this.disciplinaDAO = disciplinaDAO;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinaDAO.findAll();
    }

    public Disciplina getOneDisciplina(Long id) {
        return disciplinaDAO.findById(id).get();
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
    }

    public List<Disciplina> getRankDisciplinasLikes() {
    }
}
