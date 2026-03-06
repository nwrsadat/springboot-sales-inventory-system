package com.anwar.salesinventory.service.impl;

import com.anwar.salesinventory.dto.ProductPageResponse;
import com.anwar.salesinventory.mapper.ProductMapper;
import com.anwar.salesinventory.model.Product;
import com.anwar.salesinventory.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public ProductPageResponse findAll(
            int page,
            int size,
            String search)
    {
        if (page < 0) {
            page = 0;
        }

        if (size < 0) {
            size = 10;
        }

        String searchPattern = search == null || search.isBlank()
                ? "%"
                : "%" + search.toLowerCase(Locale.ROOT) + "%";

        int offset = page * size;

        int totalElements = productMapper.count(searchPattern);
        int totalPages = (int) Math.ceil((double) totalElements / size);

        List<Product> products = productMapper.findAll(offset, size, searchPattern);

        return new ProductPageResponse(
                products,
                page,
                size,
                totalElements,
                totalPages
        );
    }
}
