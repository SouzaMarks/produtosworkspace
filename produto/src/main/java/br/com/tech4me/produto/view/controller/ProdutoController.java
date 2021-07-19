package br.com.tech4me.produto.view.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;

import br.com.tech4me.produto.service.ProdutoService;
import br.com.tech4me.produto.shared.ProdutoDTO;
import br.com.tech4me.produto.view.model.ProdutoRequest;
import br.com.tech4me.produto.view.model.ProdutoResponse;
import br.com.tech4me.produto.view.model.ProdutoResponseDetalhes;



@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    @Autowired
    ProdutoService servico;

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> obterTodosProdutos() {
        ModelMapper mapa = new ModelMapper();
        List<ProdutoDTO> prodDtos = servico.obterTodos();
        List<ProdutoResponse> prodResponse = prodDtos.stream()
            .map(pes -> mapa.map(pes, ProdutoResponse.class))
            .collect(Collectors.toList());

        return new ResponseEntity<>(prodResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoResponseDetalhes> obterUmaPessoa(@PathVariable Integer codigo){
        Optional<ProdutoDTO> prod = servico.obterPorCodigo(codigo);

        if (prod.isPresent()) {
            return new ResponseEntity<>(new ModelMapper().map(prod.get(), ProdutoResponseDetalhes.class), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/status")
    public String status(@Value("${local.server.port}") String porta){
        return String.format("Serviço rodando na porta %s", porta);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> criarUmaProduto(@RequestBody @Valid ProdutoRequest produto) {
        ModelMapper mapa = new ModelMapper();
        ProdutoDTO prodDto = mapa.map(produto, ProdutoDTO.class);
        prodDto = servico.cadastrarProduto(prodDto);
        return new ResponseEntity<>(mapa.map(prodDto, ProdutoResponse.class), HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> remover(@PathVariable String id){
        servico.removerProduto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoResponse> atualizarPessoa(@PathVariable String id, @RequestBody @Valid ProdutoRequest produto) {
        ModelMapper mapa = new ModelMapper();
        ProdutoDTO prodDto = mapa.map(produto, ProdutoDTO.class);
        prodDto = servico.atualizarProduto(id, prodDto);
        return new ResponseEntity<>(mapa.map(prodDto, ProdutoResponse.class), HttpStatus.OK);
    }
}
