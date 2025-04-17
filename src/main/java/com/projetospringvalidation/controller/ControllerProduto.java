package com.projetospringvalidation.controller;

import com.projetospringvalidation.model.Produto;
import com.projetospringvalidation.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ControllerProduto {

    private final ProdutoService produtoService;

    public ControllerProduto(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping()
    public List<Produto> listarProdutos(){
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable Long id){
            Produto produto = produtoService.buscarPorId(id);
            return ResponseEntity.ok(produto);
    }

    @PostMapping()
    public Produto criarProduto(@RequestBody Produto produto){
        return produtoService.salvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
