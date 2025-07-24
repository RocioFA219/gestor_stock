package com.example.productos.productos.service;

import com.example.productos.productos.Mapper.ProductMapper;
import com.example.productos.productos.ProductoDTO.ProductDTO;
import com.example.productos.productos.model.Product;
import com.example.productos.productos.repository.ProductRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository=productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream()
                .map(productMapper::toDTO)
                .toList();
    }

    public Optional<ProductDTO> getProductById(Long id){
        return productRepository.findById(id)
                .map(productMapper::toDTO);
    }
    public List<ProductDTO> getProductByNameAndStock(String name, Integer stock){
       List<Product> filtered = productRepository.findByNameAndStock(name, stock);
        return filtered.stream()
                .map(productMapper::toDTO)
                .toList();
    }
    public ProductDTO create(ProductDTO productDTO) {
        if (productDTO.getId() != null && productRepository.existsById(productDTO.getId())) {
            return null;
        }
        Product product = productMapper.toEntity(productDTO); // Convertimos el DTO a entidad
        Product saved = productRepository.save(product); // Lo guardamos en la BD
        return productMapper.toDTO(saved);
    }
    public ProductDTO update (Long id, ProductDTO dto) {
        Optional<Product> actualizado = productRepository.findById(id);
        if (actualizado.isEmpty()) {
            return null;
        }
        Product product = actualizado.get();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setSerialNumber(dto.getSerialNumber());
        product.setUnits(dto.getUnits());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setCreated(dto.getCreated());
        product.setUpdated(dto.getUpdated());
        product.setActive(dto.isActive());

        Product savedProduct = productRepository.save(product);
        return productMapper.toDTO(savedProduct);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    nada;
}

