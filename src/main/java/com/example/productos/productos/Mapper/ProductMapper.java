package com.example.productos.productos.Mapper;

import com.example.productos.productos.ProductoDTO.ProductDTO;
import com.example.productos.productos.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "serialNumber", source = "serialNumber"),
            @Mapping(target = "units", source = "units"),
            @Mapping(target = "price", source = "price"),
            @Mapping(target = "stock", source = "stock"),
            @Mapping(target = "created", source = "created"),
            @Mapping(target = "updated", source = "updated"),
            @Mapping(target = "active", source = "active")
    })
    ProductDTO toDTO(Product product);
    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "serialNumber", source = "serialNumber"),
            @Mapping(target = "units", source = "units"),
            @Mapping(target = "price", source = "price"),
            @Mapping(target = "stock", source = "stock"),
            @Mapping(target = "created", source = "created"),
            @Mapping(target = "updated", source = "updated"),
            @Mapping(target = "active", source = "active")
    })
    Product toEntity(ProductDTO dto);
}
