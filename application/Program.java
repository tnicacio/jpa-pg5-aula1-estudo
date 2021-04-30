package com.tnicacio.aulajpatads01.application;

import com.tnicacio.aulajpatads01.model.dao.DaoFactory;
import com.tnicacio.aulajpatads01.model.dao.CategoriaDAO;
import com.tnicacio.aulajpatads01.model.dao.ProdutoDAO;
import com.tnicacio.aulajpatads01.model.entities.Categoria;
import com.tnicacio.aulajpatads01.model.entities.Produto;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tnica
 */
public class Program {
    
    public static void main(String... args) {

        CategoriaDAO categoriaDao = DaoFactory.createCategoriaDao();
        ProdutoDAO produtoDao = DaoFactory.createProdutoDao();

//      Populating Database
/*        
        Categoria categoriaToInsert1 = new Categoria(null, "Cama, Mesa e Banho");        
        Categoria categoriaToInsert2 = new Categoria(null, "Eletrônicos");        
        Categoria categoriaToInsert3 = new Categoria(null, "Bebidas");        
        categoriaDao.insert(categoriaToInsert1);
        categoriaDao.insert(categoriaToInsert2);
        categoriaDao.insert(categoriaToInsert3);
        
        Categoria eletronicos = categoriaDao.findById(2L);
        Categoria camaMesaBanho = categoriaDao.findByDescricao("Cama, Mesa e Banho").get(0);
        Produto p1 = new Produto(null, "Notebook DELL", 3500.00, 123.0, eletronicos);
        Produto p2 = new Produto(null, "Moto G4", 720.00, 132.0, eletronicos);
        Produto p3 = new Produto(null, "Toalha de Banho TEKKA", 2550.99, 150.0, camaMesaBanho);
          
        produtoDao.insert(p1);
        produtoDao.insert(p2);
        produtoDao.insert(p3);
*/


//      Testing DeleteById        
//        produtoDao.deleteById(1L);
//        categoriaDao.deleteById(7L);
  

//      Testing FindById
//        Categoria categoriaToFindById = categoriaDao.findById(1L);
//        if (categoria != null) {
//            System.out.println(categoria.getDescricao());
//        }

//      Testing Update
//        Categoria categoriaToUpdate = categoriaDao.findById(3L);
//        if (categoriaToUpdate != null) {
//            categoriaToUpdate.setDescricao("Laticínios");
//        }
//        categoriaDao.update(categoriaToUpdate);;

//      Testing findByDescricao
//        List<Categoria> categoriasToFindByDescricao = categoriaDao.findByDescricao("lat");
//        if (categoriasToFindByDescricao != null && 
//                !categoriasToFindByDescricao.isEmpty()){
//            List<String> descricoes = categoriasToFindByDescricao
//                  .stream().map(cat -> cat.getDescricao())
//                  .collect(Collectors.toList());
//            System.out.println(descricoes);
//        }

//      Testing FindAll
//        List<Categoria> categorias = categoriaDao.findAll();
//        if (categorias != null && !categorias.isEmpty()) {
//            System.out.println(categorias.stream().map(cat ->
//                                "[id: " + cat.getIdcategoria() + 
//                                ", descricao: " + cat.getDescricao() + "]")
//                                .collect(Collectors.toList()));
//        }
//
//        List<Produto> produtos = produtoDao.findAll();
//        if (produtos != null && !produtos.isEmpty()) {
//            System.out.println(produtos.stream().map(prod ->
//                                "[id: " + prod.getIdproduto()+ 
//                                ", descricao: " + prod.getDescricao() + "]")
//                                .collect(Collectors.toList()));
//        }

//      Testing findByDescricaoAndIdCategoria
//        List<Produto> produtosByDescAndIdCat = produtoDao;
//                .findByDescricaoAndIdCategoria("moto", 2L);
//        if (produtosByDescAndIdCat != null && !produtosByDescAndIdCat.isEmpty()) {
//            System.out.println(produtosByDescAndIdCat.stream().map(prod ->
//                                "[id: " + prod.getIdproduto()+ 
//                                ", descricao: " + prod.getDescricao() + "]")
//                                .collect(Collectors.toList()));
//        }
    }
}
