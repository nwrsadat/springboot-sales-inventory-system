package com.anwar.salesinventory.service;

import com.anwar.salesinventory.dto.ProductPageResponse;

import java.util.List;

public interface ProductService {
    ProductPageResponse findAll(int page, int size);
}
