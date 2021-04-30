package com.tnicacio.aulajpatads01.model.dao.impl;

import com.tnicacio.aulajpatads01.em.EM;
import com.tnicacio.aulajpatads01.model.dao.ProdutoDAO;
import com.tnicacio.aulajpatads01.model.entities.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tnica
 */
public class ProdutoDaoEM implements ProdutoDAO{
    
     private EntityManager em;
    
    public ProdutoDaoEM(EntityManager em){
        this.em = em;
    }

    @Override
    public void insert(Produto obj) {
            try {
            em = EM.getEntityManager();
            em.getTransaction().begin();
            System.out.println("Inserindo produto " + obj.getDescricao());
            em.persist(obj);
            em.getTransaction().commit();
            System.out.println("Produto inserido com sucesso!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
            if (isActiveTransaction()) {
                em.getTransaction().rollback();
                System.out.println("Erro na inserção do Produto. Realizado rollback...");
            }
        } finally {
            EM.close();
        }
    }

    @Override
    public void update(Produto obj) {
        try {
            em = EM.getEntityManager();
            em.getTransaction().begin();
            System.out.println("Atualizando Produto " + obj.getIdproduto());
            em.merge(obj);
            em.getTransaction().commit();
            System.out.println("Produto atualizado com sucesso!");

        } catch(Exception e) {
            System.out.println(e.getMessage());
            if (isActiveTransaction()) {
                em.getTransaction().rollback();
                System.out.println("Erro na atualização do Produto. Realizado rollback...");
            }
        } finally {
            EM.close();
        }
    }

    @Override
    public void deleteById(Long id) {
        Produto produto = findById(id);
        if (produto == null){
            System.out.println("Produto não encontrado");
            return;
        }

        try {
            em = EM.getEntityManager();
            em.getTransaction().begin();
            
            if (!em.isOpen()) {
                em = EM.getEntityManager();
                em.getTransaction().begin();
            }
            
            if (!em.contains(produto)) {
                produto = em.merge(produto);
            }
            
            System.out.println("Excluindo Produto " + id);
            em.remove(produto);
            em.getTransaction().commit();
            System.out.println("Produto excluído com sucesso!");

        } catch(Exception e) {
            System.out.println(e.getMessage());
            if (isActiveTransaction()) {
                em.getTransaction().rollback();
                System.out.println("Erro na exclusão do Produto. Realizado rollback...");
            }
        } finally {
            EM.close();
        }   
    }

    @Override
    public Produto findById(Long id) {
        Produto produto = null;
        try {
            em = EM.getEntityManager();
            produto = em.find(Produto.class, id);
            System.out.println("Busca pelo Produto " + id + " finalizada");

        } catch(Exception e) {
            System.out.println("Erro na busca pelo Produto " + id);
            System.out.println(e.getMessage());
        } finally {
            EM.close();
        }
        return produto;   
    }

    @Override
    public List<Produto> findByDescricao(String desc) {
        List<Produto> produtos = new ArrayList<>();

        try {
            String descToUpperCase = "";
            if (desc != null && !"".equals(desc.trim())) {
                descToUpperCase = "%" + desc.toUpperCase() + "%";
            }
            
            em = EM.getEntityManager();
            produtos = em.createQuery(
                "SELECT p FROM Produto p "
                + "WHERE upper(p.descricao) LIKE upper(:desc) "
                + "ORDER BY p.descricao", Produto.class)
                .setParameter("desc", descToUpperCase)
                .getResultList();
            
            System.out.println("Busca pelo Produto com descrição '" + desc + "' finalizada");
        } catch(Exception e) {
            System.out.println("Erro na busca pelo Produto de descrição '" + desc + "'");
            System.out.println(e.getMessage());
        } finally {
            EM.close();
        }
        return produtos;      
     }

    @Override
    public List<Produto> findAll() {
        List<Produto> produtos = new ArrayList<>();
        try {
            em = EM.getEntityManager();         
            produtos = em.createQuery(
                "SELECT p FROM Produto p "
                + "ORDER BY p.descricao", Produto.class)
                .getResultList();
            
            System.out.println("Busca pelo Produto finalizada");
        } catch(Exception e) {
            System.out.println("Erro na busca pelo Produto");
            System.out.println(e.getMessage());
        } finally {
            EM.close();
        }
        return produtos;      
    }

    @Override
    public List<Produto> findByDescricaoAndIdCategoria(String desc, Long idcategoria) {
        List<Produto> produtos = new ArrayList<>();
        if (idcategoria == null){
            return produtos;
        }
        
        try {
            String descToUpperCase = "";
            if (desc != null && !"".equals(desc.trim())) {
                descToUpperCase = "%" + desc.toUpperCase() + "%";
            }
            
            em = EM.getEntityManager();
            produtos = em.createQuery(
                "SELECT p FROM Produto p "
                + "WHERE upper(p.descricao) LIKE upper(:desc) "
                + "AND p.categoria.idcategoria = :idcat "
                + "ORDER BY p.descricao", Produto.class)
                .setParameter("desc", descToUpperCase)
                .setParameter("idcat", idcategoria)
                .getResultList();
            
            System.out.println("Busca pelo Produto com descrição '" + desc + 
                    "' e idcategoria " + idcategoria + " finalizada");
        } catch(Exception e) {
            System.out.println("Erro na busca pelo Produto de descrição '" +
                    desc + "' e idcategoria " + idcategoria);
            System.out.println(e.getMessage());
        } finally {
            EM.close();
        }
        return produtos;
    }
    
    private boolean isActiveTransaction(){
        return em != null && em.getTransaction() != null && em.getTransaction().isActive();
    }
}
