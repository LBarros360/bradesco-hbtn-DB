package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Aluno {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String nome;

    @Column
    private String matricula;

    @Column
    private Date nascimento;

    @Column
    private String email;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    @ManyToMany(mappedBy = "alunos", cascade = CascadeType.ALL)
    private List<Curso> cursos;

    public Aluno() {}

    public Aluno(String nome, String matricula, Date nascimento, String email) {
        this.nome = nome;
        this.matricula = matricula;
        this.nascimento = nascimento;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    public List<Endereco> getEnderecos() {
        return enderecos;
    }
    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    public List<Curso> getCursos() {
        return cursos;
    }
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", email='" + email + '\'' +
                ", cursos=" + cursos +
                '}';
    }
}
