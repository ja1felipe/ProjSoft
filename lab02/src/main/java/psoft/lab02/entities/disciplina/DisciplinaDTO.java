package psoft.lab02.entities.disciplina;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class DisciplinaDTO {

    private String nome;
    private Double nota;
    private String comentarios;
    private Integer likes;

    public DisciplinaDTO(String nome, Double nota, String comentarios, Integer likes){
        this.nome = nome;
        this.nota = nota;
        this.comentarios = comentarios;
        this.likes = likes;
    }
    public DisciplinaDTO(Double nota){
        this.nota = nota;
    }

    public DisciplinaDTO(String comentarios){
        this.comentarios = comentarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}