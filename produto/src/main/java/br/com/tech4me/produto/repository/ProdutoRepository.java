package br.com.tech4me.produto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.produto.model.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {
    
}
