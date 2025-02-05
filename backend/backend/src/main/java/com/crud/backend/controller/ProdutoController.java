package com.crud.backend.controller;

import com.crud.backend.entity.Customer;
import com.crud.backend.entity.Produto;
import com.crud.backend.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    //Post
    @PostMapping("/produto")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto saveProduto(@RequestBody Produto produto) {
        return produtoService.saveProduto(produto);
    }

    //List
    @GetMapping("/produto")
    private List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    //List Id
    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        Produto Produto = produtoService.getProdutoById(id);
        if (Produto == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(Produto);
    }

    //Update
    @PutMapping("/customer/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produto) {
        Produto existingProduto = produtoService.getProdutoById(id);
        if (existingProduto == null)
            return ResponseEntity.notFound().build();
        existingProduto.setName(produto.getName());
        existingProduto.setEmail(produto.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        Customer updateCustomer = customerService.updateCustomer(existingCustomer);
        return ResponseEntity.ok(updateCustomer);
    }

    //Deletar

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        Customer existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer == null)
            return ResponseEntity.notFound().build();
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }


}
