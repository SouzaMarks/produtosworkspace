package br.com.tech4me.produto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("produto")
public class Produto {
    @Id
    private String id;
    private double valor;
    private String nome;
    private int quantidadeEstoque;

    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    @Override
    public String toString() {
        return "Produto [codigo=" + id + ", nome=" + nome + ", quantidadeEstoque=" + quantidadeEstoque + ", valor="
                + valor + "]";
    }
    
    
}
