package br.com.tech4me.produto.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.produto.shared.ProdutoDTO;

public interface ProdutoService {
    List<ProdutoDTO> obterTodos();
    ProdutoDTO cadastrarProduto(ProdutoDTO pessoa);
    void removerProduto(String id);
    ProdutoDTO atualizarProduto(String id, ProdutoDTO pessoa);
    Optional<ProdutoDTO> obterPorCodigo(Integer codigo);
}
