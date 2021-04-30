package com.tnicacio.aulajpatads01.model.dao.impl;

import com.tnicacio.aulajpatads01.model.dao.ProdutoDAO;
import com.tnicacio.aulajpatads01.model.entities.Produto;
import java.util.List;

/**
 *
 * @author tnica
 */
public class ProdutoDaoEM implements ProdutoDAO{

    @Override
    public void insert(Produto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Produto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> findByDescricao(String desc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> findByDescricaoAndIdCategoria(String desc, Integer idcategoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
