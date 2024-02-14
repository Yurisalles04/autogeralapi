import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ControllerProdutoTest {

   
    private ServiceProduto serviceProduto;


    private ControllerProduto controllerProduto;

 
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1L, "Produto 1"));
        produtos.add(new Produto(2L, "Produto 2"));
        when(serviceProduto.getAllProdutos()).thenReturn(produtos);

       
        ResponseEntity<List<Produto>> response = controllerProduto.getProdutos();

       
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void getProduto() {
       
        long id = 1L;
        Produto produto = new Produto(id, "Produto Teste");
        when(serviceProduto.getProdutoById(id)).thenReturn(produto);

       
        ResponseEntity<Produto> response = controllerProduto.getProduto(id);

   
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(id, response.getBody().getId());
    }

    @Test
    void deleteProduto() {

        ResponseEntity<Void> response = controllerProduto.deleteProduto(1L);

        // Verifying service method invocation
        verify(serviceProduto, times(1)).deleteProdutoById(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void save() {
        
        Produto produto = new Produto(1L, "Novo Produto");
        when(serviceProduto.save(produto)).thenReturn(produto);

        
        ResponseEntity<Produto> response = controllerProduto.save(produto);

      
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(produto, response.getBody());
    }

    @Test
    void update() {
      
        ResponseEntity<Void> response = controllerProduto.update(new Produto(), 1L);

        
        verify(serviceProduto, times(1)).update(1L, new Produto());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
