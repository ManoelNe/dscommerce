package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Optional<Product> result = repository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product);

        return dto;

    }

    // Método para fazer busca com Page
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> result = repository.findAll(pageable);
        return result.map(x-> new ProductDTO(x));
    }


    /* Método para buscar tadas as lista

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        List<Product> result = repository.findAll();

        // Pega a lista de produtos do banco (Entity),
        // percorre cada item (stream),
        // transforma cada Product em ProductDTO (map),
        // e devolve tudo como uma nova lista de DTO
        return result.stream().map(x -> new ProductDTO(x)).toList();
    } */



}
