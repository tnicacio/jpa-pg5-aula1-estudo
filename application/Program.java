package com.tnicacio.aulajpatads01.application;

import com.tnicacio.aulajpatads01.model.dao.DaoFactory;
import com.tnicacio.aulajpatads01.model.dao.CategoriaDAO;
import com.tnicacio.aulajpatads01.model.entities.Categoria;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tnica
 */
public class Program {
    
    public static void main(String... args) {
        CategoriaDAO categoriaDao = DaoFactory.createCategoriaDao();
        
//        Categoria categoriaToInsert = new Categoria(null, "Cama, Mesa e Banho");        
//        categoriaDao.insert(categoria);

//        Categoria categoriaToFindById = categoriaDao.findById(1L);
//        if (categoria != null) {
//            System.out.println(categoria.getDescricao());
//        }

//          Categoria categoriaToUpdate = categoriaDao.findById(3L);
//          if (categoriaToUpdate != null) {
//              categoriaToUpdate.setDescricao("Laticínios");
//          }
//          categoriaDao.update(categoriaToUpdate);

//            List<Categoria> categoriasToFindByDescricao = categoriaDao.findByDescricao("lat");
//            if (categoriasToFindByDescricao != null && !categoriasToFindByDescricao.isEmpty()){
//                List<String> descricoes = categoriasToFindByDescricao.stream().map(cat ->
//                        cat.getDescricao()
//                ).collect(Collectors.toList());
//                System.out.println(descricoes);
//            }

//            categoriaDao.deleteById(3L);

            List<Categoria> categorias = categoriaDao.findAll();
            if (categorias != null && !categorias.isEmpty()) {
                System.out.println(categorias.stream().map(cat ->
                                    "[id: " + cat.getIdcategoria() + 
                                    ", descricao: " + cat.getDescricao() + "]")
                                    .collect(Collectors.toList()));
            }
    }
}
