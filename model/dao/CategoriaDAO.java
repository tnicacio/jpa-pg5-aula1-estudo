package com.tnicacio.aulajpatads01.model.dao;

import java.util.List;
import com.tnicacio.aulajpatads01.model.entities.Categoria;
/**
 *
 * @author tnica
 */
public interface CategoriaDAO {
    
    void insert(Categoria obj);
    void update(Categoria obj);
    void deleteById(Long id);
    Categoria findById(Long id);
    List<Categoria> findByDescricao(String desc);
    List<Categoria> findAll();
}
