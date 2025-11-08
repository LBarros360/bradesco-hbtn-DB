package models;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entities.Aluno;

public class AlunoModel {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public AlunoModel(){}

    public void create(Aluno aluno) {

        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("[Create Pessoa]Iniciando a transação.");
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.close();
            System.err.println("[Create Pessoa]Erro ao criar a Pessoa." + e.getMessage());
        } finally {
            em.close();
            System.out.println("[Create Pessoa]Finalizando a transação.");
        }
    }

    public Aluno findById(Long id) {

        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("[findById Pessoa]Iniciando a transação.");
            return em.find(Aluno.class, id);
        } catch (Exception e) {
            System.err.println("[findById Pessoa]Erro ao buscar a Pessoa." + e.getMessage());
            return null;
        } finally {
            em.close();
            System.out.println("[findById Pessoa]Finalizando a transação.");
        }
    }

    public  List<Aluno> findAll() {

        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("[findAll Pessoa]Iniciando a transação.");
            return em.createQuery("FROM Aluno", Aluno.class).getResultList();
        } catch (Exception e) {
            System.err.println("[findAll Pessoa]Erro ao buscar as Pessoas." + e.getMessage());
            return null;
        } finally {
            em.close();
            System.out.println("[findAll Pessoa]Finalizando a transação.");
        }
    }

    public void update(Aluno aluno) {

        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("[update Pessoa]Iniciando a transação.");
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.close();
            System.err.println("[update Pessoa]Erro ao atualizar a Pessoa." + e.getMessage());
        } finally {
            em.close();
            System.out.println("[update Pessoa]Finalizando a transação.");
        }
    }

    public void delete(Aluno aluno) {

        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("[delete Pessoa]Iniciando a transação.");
            em.getTransaction().begin();
            em.remove(em.contains(aluno) ? aluno : em.merge(aluno));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.close();
            System.err.println("[delete Pessoa]Erro ao remover a Pessoa." + e.getMessage());
        } finally {
            em.close();
            System.out.println("[delete Pessoa]Finalizando a transação.");
        }
    }
}
