package com.tnicacio.aulajpatads01.model.dao.impl;

import com.tnicacio.aulajpatads01.em.EM;
import com.tnicacio.aulajpatads01.model.dao.CategoriaDAO;
import com.tnicacio.aulajpatads01.model.entities.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tnica
 */
public class CategoriaDaoEM implements CategoriaDAO {
    
    private EntityManager em;
    
    public CategoriaDaoEM(EntityManager em){
        this.em = em;
    }

    @Override
    public void insert(Categoria obj) {
        try {
            em = EM.getEntityManager();
            em.getTransaction().begin();
            System.out.println("Inserindo categoria " + obj.getDescricao());
            em.persist(obj);
            em.getTransaction().commit();
            System.out.println("Categoria inserida com sucesso!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
            if (isActiveTransaction()) {
                em.getTransaction().rollback();
                System.out.println("Erro na inserção da Categoria. Realizado rollback...");
            }
        } finally {
            EM.close();
        }
    }

    @Override
    public void update(Categoria obj) {
        try {
            em = EM.getEntityManager();
            em.getTransaction().begin();
            System.out.println("Atualizando categoria " + obj.getIdcategoria());
            em.merge(obj);
            em.getTransaction().commit();
            System.out.println("Categoria atualizada com sucesso!");

        } catch(Exception e) {
            System.out.println(e.getMessage());
            if (isActiveTransaction()) {
                em.getTransaction().rollback();
                System.out.println("Erro na atualização da Categoria. Realizado rollback...");
            }
        } finally {
            EM.close();
        }
    }

    @Override
    public void deleteById(Long id) {
        Categoria categoria = findById(id);
        
        if (categoria == null){
            System.out.println("Categoria não encontrada");
            return;
        }

        try {
            em = EM.getEntityManager();
            em.getTransaction().begin();
            
            if (!em.isOpen()) {
                em = EM.getEntityManager();
                em.getTransaction().begin();
            }
            
            if (!em.contains(categoria)) {
                categoria = em.merge(categoria);
            }
            
            System.out.println("Excluindo categoria " + id);
            em.remove(categoria);
            em.getTransaction().commit();
            System.out.println("Categoria excluída com sucesso!");

        } catch(Exception e) {
            System.out.println(e.getMessage());
            if (isActiveTransaction()) {
                em.getTransaction().rollback();
                System.out.println("Erro na exclusão da Categoria. Realizado rollback...");
            }
        } finally {
            EM.close();
        }
    }

    @Override
    public Categoria findById(Long id) {
        Categoria categoria = null;
        try {
            em = EM.getEntityManager();
            categoria = em.find(Categoria.class, id);
            System.out.println("Busca pela Categoria " + id + " finalizada");

        } catch(Exception e) {
            System.out.println("Erro na busca pela Categoria " + id);
            System.out.println(e.getMessage());
        } finally {
            EM.close();
        }
        return categoria;
    }

    @Override
    public List<Categoria> findByDescricao(String desc) {
        List<Categoria> categorias = new ArrayList<>();

        try {
            String descToUpperCase = "";
            if (desc != null && !"".equals(desc.trim())) {
                descToUpperCase = "%" + desc.toUpperCase() + "%";
            }
            
            em = EM.getEntityManager();
            categorias = em.createQuery(
                "SELECT c FROM Categoria c "
                + "WHERE upper(c.descricao) LIKE upper(:desc) "
                + "ORDER BY c.descricao", Categoria.class)
                .setParameter("desc", descToUpperCase)
                .getResultList();
            
            System.out.println("Busca pela Categoria com descrição '" + desc + "' finalizada");
        } catch(Exception e) {
            System.out.println("Erro na busca pela Categoria de descrição '" + desc + "'");
            System.out.println(e.getMessage());
        } finally {
            EM.close();
        }
        return categorias;        
    }

    @Override
    public List<Categoria> findAll() {
        List<Categoria> categorias = new ArrayList<>();
        try {
            em = EM.getEntityManager();
            categorias = em.createQuery(
                "SELECT c FROM Categoria c "
                + "ORDER BY c.descricao", Categoria.class)
                .getResultList();
            
            System.out.println("Busca por todas as categorias finalizada");
        } catch(Exception e) {
            System.out.println("Erro na busca por todas as categorias");
            System.out.println(e.getMessage());
        } finally {
            EM.close();
        }
        return categorias;  
    }
    
    private boolean isActiveTransaction(){
        return em != null && em.getTransaction() != null && em.getTransaction().isActive();
    }
}
