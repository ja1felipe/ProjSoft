package psoft.lab02.entities.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String email;

    private String nome;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User(String email, String nome, String password){
        this.email = email;
        this.password = password;
        this.nome = nome;
    }

    public User(){ }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
