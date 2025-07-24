package com.example.productos.productos.ProductoDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("serialNumber")
    private Integer serialNumber;
    @JsonProperty("units")
    private Integer units;
    @JsonProperty("price")
    private double price;
    @JsonProperty("stock")
    private Integer stock;
    @JsonProperty("created")
    private LocalDateTime created;
    @JsonProperty("updated")
    private LocalDateTime updated;
    @JsonProperty("active")
    private boolean active;
}
