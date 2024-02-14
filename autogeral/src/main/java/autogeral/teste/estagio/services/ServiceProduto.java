package autogeral.teste.estagio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import autogeral.teste.estagio.entities.Produto;
import autogeral.teste.estagio.repositories.RepositoryProduto;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class ServiceProduto {

    @Autowired
    private RepositoryProduto repository;

    public List<Produto> getAllProdutos() {
        return repository.findAll();
    }

    public Produto getProdutoById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
    }

    @Transactional
    public void deleteProdutoById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Produto não encontrado");
        }
    }

    @Transactional
    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    @Transactional
    public void update(Long id, Produto produtoAtualizado) {
        Produto produtoExistente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        produtoExistente.setNome(produtoAtualizado.getNome());
        produtoExistente.setValor(produtoAtualizado.getValor());
    }
}
