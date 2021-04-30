package com.tnicacio.aulajpatads01.model.dao;

import com.tnicacio.aulajpatads01.em.EM;
import com.tnicacio.aulajpatads01.model.dao.impl.CategoriaDaoEM;
import com.tnicacio.aulajpatads01.model.dao.impl.ProdutoDaoEM;


/**
 *
 * @author tnica
 */
public class DaoFactory {
    
    public static CategoriaDAO createCategoriaDao(){
        return new CategoriaDaoEM(EM.getEntityManager());
    }

    public static ProdutoDAO createProdutoDao(){
         return new ProdutoDaoEM(EM.getEntityManager());
    }
    
}
