package com.anwar.salesinventory.service.impl;

import com.anwar.salesinventory.dto.ProductPageResponse;
import com.anwar.salesinventory.mapper.ProductMapper;
import com.anwar.salesinventory.model.Product;
import com.anwar.salesinventory.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public ProductPageResponse findAll(int page, int size) {
        if (page < 0) {
            page = 0;
        }

        if (size < 0) {
            size = 10;
        }

        int offset = page * size;

        int totalElements = productMapper.count();
        int totalPages = (int) Math.ceil((double) totalElements / size);

        List<Product> products = productMapper.findAll(offset, size);

        return new ProductPageResponse(
                products,
                page,
                size,
                totalElements,
                totalPages
        );
    }
}
