package autogeral.teste.estagio.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import autogeral.teste.estagio.entities.Produto;
import autogeral.teste.estagio.services.ServiceProduto;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("produtos")
public class ControllerProduto {

    @Autowired
    private ServiceProduto service;

    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos() {
        List<Produto> produtos = this.service.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable long id) {
        Produto produto = this.service.getProdutoById(id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable long id) {
        this.service.deleteProdutoById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        Produto savedProduto = this.service.save(produto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedProduto.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedProduto);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody Produto produto,
                                        @PathVariable long id) {
        this.service.update(id, produto);
        return ResponseEntity.ok().build();
    }
}
