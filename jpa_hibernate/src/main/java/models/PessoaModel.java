package models;

import entities.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class PessoaModel {

    public void create(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("[Create Pessoa]Iniciando a transação.");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("[Create Pessoa]Pessoa criada com sucesso. Nome: " + p.getNome() + " ID: " + p.getId());
        } catch (Exception e) {
            em.close();
            System.err.println("[Create Pessoa]Erro ao criar a Pessoa." + e.getMessage());
        } finally {
            em.close();
            System.out.println("[Create Pessoa]Finalizando a transação.");
        }
    }

    public void update(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("[Update Pessoa] Iniciando a transação.");
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("[Update Pessoa] Pessoa atualizada com sucesso. Nome: " +p.getNome()+ " ID: " + p.getId());
        } catch (Exception e) {
            em.close();
            System.err.println("[Update Pessoa] Erro ao atualizar a Pessoa." + e.getMessage());
        }finally {
            em.close();
            System.out.println("[Update Pessoa] Finalizando a transação.");
        }
    }

    public void delete(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("[Delete Pessoa] Iniciando a transação.");
            em.getTransaction().begin();
            Pessoa pessoa = em.find(Pessoa.class, p.getId());
            if (pessoa != null) {
                em.remove(pessoa);
                em.getTransaction().commit();
                System.out.println("[Delete Pessoa] Pessoa removida com sucesso. ID: " + p.getId());
            }
        } catch (Exception e) {
            em.close();
            System.err.println("[Delete Pessoa] Erro ao remover a Pessoa." + e.getMessage());
        }finally {
            em.close();
            System.out.println("[Delete Pessoa] Finalizando a transação.");
        }
    }

    public Pessoa findById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Pessoa p = new Pessoa();
        try {

            System.out.println("[FindById Pessoa] Iniciando a transação.");
            em.getTransaction().begin();
            p = em.find(Pessoa.class, id);
            if (p != null) {
                System.out.println("[FindById Pessoa]Pessoa consultada com sucesso. Nome: " + p.getNome() + " ID: " + p.getId());
            }
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            em.close();
            System.err.println("[FindById Pessoa] Erro ao encontrar a pessoa." + e.getMessage());
        }finally {
            em.close();
            System.out.println("[FindById Pessoa] Finalizando a transação.");
            return p;
        }
    }

    public List<Pessoa> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        List<Pessoa> pessoas = new ArrayList<>();
        try {
            System.out.println("[FindAll Pessoa] Iniciando a transação");
            em.getTransaction().begin();
            String jpql = "SELECT e FROM " + Pessoa.class.getSimpleName() + " e";
            TypedQuery<Pessoa> query = em.createQuery(jpql, Pessoa.class);
            pessoas = query.getResultList();
            em.getTransaction().commit();
            if (!pessoas.isEmpty()) {
                System.err.println("[FindAll Pessoa] Pessoa encontrados. Total: " + pessoas.size());
            }
        } catch (Exception e) {
            em.close();
            System.err.println("[FindAll Pessoa] Erro ao encontrar as pessoas." + e.getMessage());
        }finally {
            em.close();
            System.out.println("[FindAll Pessoa] Finalizando a transação");
            return pessoas;
        }
    }
}
