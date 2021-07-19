package br.com.tech4me.produto.shared;

import java.time.LocalDate;

import br.com.tech4me.produto.model.Produto;

public class Venda {
    private Integer idVenda;
    private String produtoVendido;
    private LocalDate dataProduto;
    private Produto produto;
    
    public Integer getIdVenda() {
        return idVenda;
    }
    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }
    public String getProdutoVendido() {
        return produtoVendido;
    }
    public void setProdutoVendido(String produtoVendido) {
        this.produtoVendido = produtoVendido;
    }
    public LocalDate getDataProduto() {
        return dataProduto;
    }
    public void setDataProduto(LocalDate dataProduto) {
        this.dataProduto = dataProduto;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
}


