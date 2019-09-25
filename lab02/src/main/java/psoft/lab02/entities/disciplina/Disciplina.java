package psoft.lab02.entities.disciplina;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
@AllArgsConstructor
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private Double nota;
    private String comentarios;
    private Integer likes;

    public Disciplina(String nome, Double nota, String comentarios, Integer likes){
        this.nome = nome;
        this.nota = nota;
        this.comentarios = comentarios;
        this.likes = likes;
    }

    public Disciplina(@JsonProperty("nome") String nome){
        this.nome = nome;
        this.nota = 0.0;
        this.comentarios = "";
        this.likes = 0;
    }

    public Disciplina(){ }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
