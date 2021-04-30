package com.tnicacio.aulajpatads01.model.dao;

import com.tnicacio.aulajpatads01.model.dao.impl.CategoriaDaoEM;
import com.tnicacio.aulajpatads01.model.dao.impl.ProdutoDaoEM;


/**
 *
 * @author tnica
 */
public class DaoFactory {
    
    public static CategoriaDAO createCategoriaDao(){
        return new CategoriaDaoEM();
    }

    public static ProdutoDAO createProdutoDao(){
         return new ProdutoDaoEM();
    }
    
}
