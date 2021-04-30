package com.tnicacio.aulajpatads01.model.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author tnica
 */
@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproduto;
    
    private String descricao;
    private Long preco;
    private Long estoque;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="idcategoria", referencedColumnName = "idcategoria")
    private Categoria categoria;
    
    public Produto(){
    }

    public Produto(Long idproduto, String descricao, Long preco, Long estoque, Categoria categoria) {
        this.idproduto = idproduto;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    public Long getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Long idproduto) {
        this.idproduto = idproduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getPreco() {
        return preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;
    }

    public Long getEstoque() {
        return estoque;
    }

    public void setEstoque(Long estoque) {
        this.estoque = estoque;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idproduto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.idproduto, other.idproduto)) {
            return false;
        }
        return true;
    }
    
    
    
}
