package models;

import entities.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel {
    public void create(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("[Create Produto]Iniciando a transação.");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("[Create Produto]Produto criado com sucesso. Nome: " + p.getNome() + " ID: " + p.getId());
        } catch (Exception e) {
            em.close();
            System.err.println("[Create Produto]Erro ao criar o produto." + e.getMessage());
        } finally {
            em.close();
            System.out.println("[Create Produto]Finalizando a transação.");
        }
    }

    public void update(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("[Update Produto] Iniciando a transação.");
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("[Update Produto] Produto atualizado com sucesso. Nome: " +p.getNome()+ " ID: " + p.getId());
        } catch (Exception e) {
            em.close();
            System.err.println("[Update Produto] Erro ao atualizar o produto." + e.getMessage());
        }finally {
            em.close();
            System.out.println("[Update Produto] Finalizando a transação.");
        }
    }

    public void delete(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("[Delete Produto] Iniciando a transação.");
            em.getTransaction().begin();
            Produto produto = em.find(Produto.class, p.getId());
            if (produto != null) {
                em.remove(produto);
                em.getTransaction().commit();
                System.out.println("[Delete Produto] Produto removido com sucesso. ID: " + p.getId());
            }
        } catch (Exception e) {
            em.close();
            System.err.println("[Delete Produto] Erro ao remover o produto." + e.getMessage());
        }finally {
            em.close();
            System.out.println("[Delete Produto] Finalizando a transação.");
        }
    }

    public Produto findById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Produto p = new Produto();
        try {

            System.out.println("[FindById Produto] Iniciando a transação.");
            em.getTransaction().begin();
            p = em.find(Produto.class, id);
            if (p != null) {
                System.out.println("[FindById Produto]Produto consultado com sucesso. Nome: " + p.getNome() + " ID: " + p.getId());
            }
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            em.close();
            System.err.println("[FindById Produto] Erro ao encontrar o produto." + e.getMessage());
        }finally {
            em.close();
            System.out.println("[FindById Produto] Finalizando a transação.");
            return p;
        }
    }

    public List<Produto> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        List<Produto> produtos = new ArrayList<>();
        try {
            System.out.println("[FindAll Produto] Iniciando a transação");
            em.getTransaction().begin();
            String jpql = "SELECT e FROM " + Produto.class.getSimpleName() + " e";
            TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);
            produtos = query.getResultList();
            em.getTransaction().commit();
            if (!produtos.isEmpty()) {
                System.err.println("[FindAll Produto] Produtos encontrados. Total: " + produtos.size());
            }
        } catch (Exception e) {
            em.close();
            System.err.println("[FindAll Produto] Erro ao encontrar os produtos." + e.getMessage());
        }finally {
            em.close();
            System.out.println("[FindAll Produto] Finalizando a transação");
            return produtos;
        }
    }
}
