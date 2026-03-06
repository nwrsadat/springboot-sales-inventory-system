package com.anwar.salesinventory.service;

import com.anwar.salesinventory.dto.ProductPageResponse;

public interface ProductService {
    ProductPageResponse findAll(int page, int size, String search);
}
