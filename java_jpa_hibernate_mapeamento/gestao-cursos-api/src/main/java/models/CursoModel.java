package models;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entities.Curso;

public class CursoModel {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public CursoModel(){};

    public void create(Curso curso) {

        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("[Create Curso]Iniciando a transação.");
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.close();
            System.err.println("[Create Curso]Erro ao criar o Curso." + e.getMessage());
        } finally {
            em.close();
            System.out.println("[Create Curso]Finalizando a transação.");
        }
    }

    public Curso findById(Long id) {

        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("[findById Curso]Iniciando a transação.");
            return em.find(Curso.class, id);
        } catch (Exception e) {
            System.err.println("[findById Curso]Erro ao buscar o Curso." + e.getMessage());
            return null;
        } finally {
            em.close();
            System.out.println("[findById Curso]Finalizando a transação.");
        }
    }

    public  List<Curso> findAll() {

        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("[findAll Curso]Iniciando a transação.");
            return em.createQuery("FROM Curso", Curso.class).getResultList();
        } catch (Exception e) {
            System.err.println("[findAll Curso]Erro ao buscar os Cursos." + e.getMessage());
            return null;
        } finally {
            em.close();
            System.out.println("[findAll Curso]Finalizando a transação.");
        }
    }

    public void update(Curso curso) {

        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("[update Curso]Iniciando a transação.");
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.close();
            System.err.println("[update Curso]Erro ao atualizar o Curso." + e.getMessage());
        } finally {
            em.close();
            System.out.println("[update Curso]Finalizando a transação.");
        }
    }

    public void delete(Curso curso) {

        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("[delete Curso]Iniciando a transação.");
            em.getTransaction().begin();
            em.remove(em.contains(curso) ? curso : em.merge(curso));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.close();
            System.err.println("[delete Curso]Erro ao remover o Curso." + e.getMessage());
        } finally {
            em.close();
            System.out.println("[delete Curso]Finalizando a transação.");
        }
    }
}