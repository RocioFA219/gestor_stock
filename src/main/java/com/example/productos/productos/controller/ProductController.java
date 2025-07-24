package com.example.productos.productos.controller;

import com.example.productos.productos.ProductoDTO.ProductDTO;
import com.example.productos.productos.service.ProductService;
import lombok.Data;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/buscar")
    public List<ProductDTO> getProductByNameAndStock(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer stock){
        return productService.getProductByNameAndStock(name, stock);
            }
    @PostMapping
    public ResponseEntity<ProductDTO> create (@RequestBody ProductDTO productDTO){
        ProductDTO creado = productService.create(productDTO);
        if(creado==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update (@PathVariable Long id, @RequestBody ProductDTO productDTO){
        ProductDTO actualizado = productService.update(id,productDTO);
        if(actualizado == null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct (@PathVariable Long id){
        Optional<ProductDTO> deleted = productService.getProductById(id);
        if(deleted.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    }

