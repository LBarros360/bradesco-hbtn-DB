package entities;

import javax.persistence.*;

@Entity
public class Telefone {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String ddd;

    @Column
    private String numero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Telefone() {}

    public Telefone(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", ddd='" + ddd + '\'' +
                ", numero='" + numero + '\'' +
                ", aluno=" + aluno +
                '}';
    }
}