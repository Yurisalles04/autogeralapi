package autogeral.teste.estagio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import autogeral.teste.estagio.entities.Produto;

public interface RepositoryProduto extends JpaRepository<Produto, Long>{
    
}
