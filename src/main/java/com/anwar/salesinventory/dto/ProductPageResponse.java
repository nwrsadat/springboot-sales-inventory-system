package com.anwar.salesinventory.dto;

import com.anwar.salesinventory.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPageResponse {
    List<Product> data;
    int page;
    int size;
    int totalElements;
    int totalPages;
}
