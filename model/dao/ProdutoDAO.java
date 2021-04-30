package com.tnicacio.aulajpatads01.model.dao;

import java.util.List;
import com.tnicacio.aulajpatads01.model.entities.Produto;

/**
 *
 * @author tnica
 */
public interface ProdutoDAO {
    
    void insert(Produto obj);
    void update(Produto obj);
    void deleteById(Integer id);
    Produto findById(Integer id);
    List<Produto> findByDescricao(String desc);
    List<Produto> findAll();
    List<Produto> findByDescricaoAndIdCategoria(String desc, Integer idcategoria);

}
