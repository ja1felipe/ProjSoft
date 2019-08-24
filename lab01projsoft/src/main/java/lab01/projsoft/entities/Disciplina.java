package lab01.projsoft.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.json.simple.JSONObject;

import java.util.Objects;

public class Disciplina{

    private Integer id;
    private String nome;
    private Double nota;

    @JsonCreator
    public Disciplina(Integer id, JSONObject obj) {
        this.id = id;
        this.nome = (String) obj.get("nome");
        this.nota = (Double) obj.get("nota");
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getNota() {
        return nota;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nota);
    }

}
