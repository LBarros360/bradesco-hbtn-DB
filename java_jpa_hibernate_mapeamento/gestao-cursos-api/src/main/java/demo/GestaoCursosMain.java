package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class GestaoCursosMain {
    public static void main(String[] args) {

        //Telefones
        Telefone telefone1 = new Telefone("41", "999142918");
        Telefone telefone2 = new Telefone("11", "999142986");

        //Enderecos
        Endereco endereco1 = new Endereco("Av. Brasil", "21", "Centro", "Curitiba", "Paraná", 80440130);
        Endereco endereco2 = new Endereco("Rua XV de Novembro", "451", "Centro", "Belo Horizonte", "Minas Gerais", 80440389);

        //Aluno
        Aluno aluno1 = new Aluno("Luiz", "1953456", new Date(), "luiz@gmail.com");
        Aluno aluno2 = new Aluno("Ana", "1953457", new Date(), "ana@gmail.com");
        aluno1.setEnderecos(List.of(endereco1));
        aluno1.setEnderecos(List.of(endereco2));
        aluno1.setTelefones(List.of(telefone1));
        aluno2.setTelefones(List.of(telefone2));
        telefone1.setAluno(aluno1);
        telefone2.setAluno(aluno2);
        endereco1.setAluno(aluno1);
        endereco2.setAluno(aluno2);


        //Materiais
        MaterialCurso materialCurso1 = new MaterialCurso("www.edu.com.br/curso1");
        MaterialCurso materialCurso2 = new MaterialCurso("www.edu.com.br/curso2");

        //Cursos
        Curso curso1 = new Curso("Programação Orientada a Objeto", "POO");
        Curso curso2 = new Curso("Estrutura de Dados", "ED");
        curso1.setMaterialCurso(materialCurso1);
        curso2.setMaterialCurso(materialCurso2);
        curso1.setAlunos(Arrays.asList(aluno1, aluno2));
        curso2.setAlunos(Arrays.asList(aluno1, aluno2));

        //Professores
        Professor professor1 = new Professor("Antonio", "123456", "antonio@edu.com");
        Professor professor2 = new Professor("Joana", "123489", "joana@edu.com");
        curso1.setProfessor(professor1);
        curso2.setProfessor(professor2);

        aluno1.setCursos(Arrays.asList(curso1, curso2));
        aluno2.setCursos(Arrays.asList(curso1, curso2));

        imprime(aluno1, professor1, curso1);
        imprime(aluno2, professor2, curso2);

        realizaOperacoesAluno(aluno1);
        realizaOperacoesCurso(curso1);

        realizaOperacoesAluno(aluno2);
        realizaOperacoesCurso(curso2);
    }

    static void imprime(Aluno a, Professor p, Curso c) {
        System.out.println(a);
        System.out.println(p);
        System.out.println(c);
    }

    static void realizaOperacoesAluno(Aluno aluno) {

        AlunoModel am = new AlunoModel();
        am.create(aluno);
        am.findById(aluno.getId());
        am.findAll();
        am.update(aluno);
        am.delete(aluno);
    }
    static void realizaOperacoesCurso(Curso curso) {
        CursoModel cm = new CursoModel();
        cm.create(curso);
        cm.findById(curso.getId());
        cm.findAll();
        cm.update(curso);
        cm.delete(curso);
    }
}
