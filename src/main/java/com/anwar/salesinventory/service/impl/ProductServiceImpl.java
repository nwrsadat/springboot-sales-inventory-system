package com.anwar.salesinventory.service.impl;

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
    public List<Product> findAll(int page, int size) {
        int offset = page * size;

        return productMapper.findAll(offset, size);
    }
}
