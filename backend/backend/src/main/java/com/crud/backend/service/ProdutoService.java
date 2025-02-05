package com.crud.backend.service;

import com.crud.backend.entity.Customer;
import com.crud.backend.entity.Produto;
import com.crud.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private final ProdutoRepository produtoRepository;


    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //Post
    public Produto saveProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    //List
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    //List Id
    public Produto getProdutoById(Long id) {

        return produtoRepository.findById(id).orElse(null);
    }


    //Update
    public Produto updateProduto(Produto customer) {
        return produtoRepository.save(customer);
    }

    //Delete
    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
